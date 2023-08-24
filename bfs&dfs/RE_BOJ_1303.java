import java.io.*;
import java.util.*;

public class RE_BOJ_1303 { // 전쟁 - 전투
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static int row;
    static int col;
    static boolean[][] visited;
    static int wPower = 0;
    static int bPower = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.valueOf(st.nextToken());
        row = Integer.valueOf(st.nextToken());

        visited = new boolean[row][col];
        board = new char[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (board[i][j] == 'W') {
                    wPower += bfs(j, i, 'W');
                } else if (board[i][j] == 'B') {
                    bPower += bfs(j, i, 'B');
                }
            }
        }

        // W B
        System.out.println(wPower + " " + bPower);
    }

    static int bfs(int x, int y, char team) {
        visited[y][x] = true;
        q.clear();
        q.add(new int[]{x, y});
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] temp = q.remove();

            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                if (newX < 0 || newX >= col || newY < 0 || newY >= row) {
                    continue;
                }

                if (visited[newY][newX]) {
                    continue;
                }

                if (board[newY][newX] != team) {
                    continue;
                }

                visited[newY][newX] = true;
                cnt++;
                q.add(new int[]{newX, newY});
            }
        }
        return (int)Math.pow(cnt, 2);
    }
}
