import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 { // 단지번호붙이기
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        // receive input
        for (int i = 0; i < N; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < chArr.length; j++) {
                arr[i][j] = Character.getNumericValue(chArr[j]);
            }
        }

        int cnt = 0;
        // iterate arr and find apt
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                cnt++;
                bfs(j, i);
            }
        }

        answer.sort(Integer::compareTo);
        StringBuilder sb = new StringBuilder();
        for (Integer num : answer) {
            sb.append(String.valueOf(num) + '\n');
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;

        int result = 0;

        while (!q.isEmpty()) {
            result++;
            int[] temp = q.remove();

            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                // 유효성 검사
                if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    continue;
                }

                // 0 이거나 방문했으면 pass
                if (arr[newY][newX] == 0 || visited[newY][newX]) {
                    continue;
                }

                q.add(new int[]{newX, newY});
                visited[newY][newX] = true;
            }
        }

        answer.add(result);
    }
}
