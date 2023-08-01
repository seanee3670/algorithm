import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 { // 안전 영역
    static int[][] board;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        board = new int[N][N];
        int maxHeight = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }

        int max = 0;
        for (int height = 0; height <= maxHeight; height++) {
            check = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!check[i][j] && board[i][j] > height) {
                        bfs(j, i, height);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);

    }

    static void bfs(int x, int y, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        check[y][x] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();

            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    continue;
                }

                if (check[newY][newX]) {
                    continue;
                }

                if (board[newY][newX] > height) {
                    check[newY][newX] = true;
                    q.add(new int[]{newX, newY});
                }
            }

        }
    }



}
