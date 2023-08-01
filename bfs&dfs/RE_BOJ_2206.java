import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RE_BOJ_2206 {
    static class Wall {
        int x;
        int y;
        boolean destroyed;
        int cnt;

        public Wall(int x, int y, boolean destroyed, int cnt) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.cnt = cnt;
        }
    }
    static int N;
    static int M;
    static int[][] maps;
    static boolean[][][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        N = Integer.valueOf(info[0]);
        M = Integer.valueOf(info[1]);

        maps = new int[N][M];
        check = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maps[i][j] = Character.getNumericValue(arr[j]);
            }
        }

        System.out.println(bfs());
        //
    }
    static int bfs() {
        Queue<Wall> q = new LinkedList<>();

        // add starting point to q
        q.offer(new Wall(0, 0, false, 1));
        check[0][0][0] = true;

        while (!q.isEmpty()) {
            Wall wall = q.poll();

            // return cnt on arrival
            if (wall.x == N - 1 && wall.y == M - 1) {
                return wall.cnt;
            }

            // search 4 directions
            for (int i = 0; i < dx.length; i++) {
                int newX = wall.x + dx[i];
                int newY = wall.y + dy[i];

                // validate
                if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
                    continue;
                }

                // check if wall has been destroyed
                if (wall.destroyed) {
                    //
                }
            }
        }
        return 0;
    }
}
