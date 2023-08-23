import java.io.*;
import java.util.*;

public class RE_BOJ_2468 { // 안전 영역
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int maxHeight = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());


        board = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }

        int max = 1;
        for (int rain = 1; rain <= maxHeight; rain++) {
            int cnt = 0;
            resetVisited();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] <= rain) {
                        continue;
                    }
                    if (visited[i][j]) {
                        continue;
                    }
                    bfs(j, i, rain);
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);


    }
    static void bfs(int x, int y, int rain) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    continue;
                }
                if (visited[newY][newX] || board[newY][newX] <= rain) {
                    continue;
                }

                visited[newY][newX] = true;
                q.add(new int[]{newX, newY});
            }
        }
    }

    static void resetVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }
}
