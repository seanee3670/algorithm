import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17406 { // 배열 돌리기
    static int N, M, K;
    static int[][] cycle;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        map = new int[N][M];

        // map 기록
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        cycle = new int[K][3];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cycle[i][0] = Integer.valueOf(st.nextToken()) - 1;
            cycle[i][1] = Integer.valueOf(st.nextToken()) - 1;
            cycle[i][2] = Integer.valueOf(st.nextToken());
        }

        permutation(0, new int[K], new boolean[K]);


    }

    private static void permutation(int cnt, int[] arr, boolean[] visited) {
        if (cnt == K) {
            doCycle(arr);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[cnt] = i;
            permutation(cnt + 1, arr, visited);
            visited[i] = false;
        }
    }

    private static void doCycle(int[] arr) {
        int[][] tmp = map;

        for (int i = 0; i < K; i++) {
            int r = cycle[arr[i]][0];
            int c= cycle[arr[i]][0];
            int s = cycle[arr[i]][0];

            for (int j = 1; j <= s; j++) {
                // up
                int upTmp = tmp[r - s][c + s];
                for (int y = c + s; y > c - s; y--) {
                    tmp[r - s][y] = tmp[r - s][y - 1];
                }

                // right
                int rightTmp = tmp[r + s][c + s];
                for (int x = r + s; x > r - s; x--) {
                    tmp[x][c + s] = tmp[x - 1][c + s];
                }
                tmp[r - s + 1][c + s] = upTmp;

                // down
                int leftTmp = tmp[r + s][c - s];
                for (int y = c - s; y < c - s; y++) {
                    tmp[r + s][y] = tmp[r + s][y + 1];
                }
                tmp[r + s][c + s - 1] = rightTmp;

                // left
                for (int x = r - s; x < r + s; x++) {
                    tmp[x][c - s] = tmp[x + 1][c - s];
                }
                tmp[r + s - 1][c - s] = leftTmp;
            }
        }
        getAnswer(tmp);
    }
    private static void getAnswer(int[][] tmp) {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += tmp[i][j];
            }
            min = Math.min(min, sum);
        }
    }

}
