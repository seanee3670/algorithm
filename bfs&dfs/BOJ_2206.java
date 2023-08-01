import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2206 { // 벽 부수고 이동하기
    static int N;
    static int M;
    static int[][] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.valueOf(split[0]);
        M = Integer.valueOf(split[1]);

        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }
    static int bfs() {
        int[][][] check = new int[2][N][M];
        // [0, N, M] : 벽 안 부수고 지나감
        // [1, N, M] : 벽 부수고 지나감

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        check[0][0][0] = 1;

        while (true) {
            int[] node = q.poll();
            if (node == null) {
                return -1;
            }

            int w = node[0];
            int x = node[1];
            int y = node[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 현재 노드가 벽이 아닐때
                if (w == 0) {
                    // 다음 노드가 벽이 아니며, 부수고 나간적이 없을때
                    if (maps[nx][ny] == 0 && check[0][nx][ny] == 0) {
                        q.add(new int[]{0, nx, ny});
                        check[0][nx][ny] = check[0][x][y] + 1;
                    }
                    // 다음 노드가 벽이며, 부수고 나간적이 없을때
                    else if (maps[nx][ny] == 1 && check[0][nx][ny] == 0) {
                        if (check[1][nx][ny] == 0) {
                            q.add(new int[]{1, nx, ny});
                            check[1][nx][ny] = check[0][x][y] + 1;
                        }
                    }
                } else {
                    if (maps[nx][ny] == 0) {
                        if (check[1][nx][ny] == 0) {
                            q.add(new int[]{1, nx, ny});
                            check[1][nx][ny] = check[1][x][y] + 1;
                        }
                    }
                }
                if (nx == N - 1 && ny == M - 1) {
                    return Math.max(check[0][nx][ny], check[1][nx][ny]);
                }
            }
        }
    }
}
