import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14503 { // 로봇청소기
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board;
    static int row;
    static int col;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());
        board = new int[row][col];

        // receive input for robot
        st = new StringTokenizer(br.readLine());

        int y = Integer.valueOf(st.nextToken());
        int x = Integer.valueOf(st.nextToken());
        int direction = Integer.valueOf(st.nextToken());

        // receive input for board
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        cnt = 1;
        dfs(x, y, direction);

        System.out.println(cnt);

    }

    static void dfs(int x, int y, int direction) {
        board[y][x] = -1;

        for (int i = 0; i < dx.length; i++) {
            direction = (direction + 3) % 4;

            int newX = x + dx[direction];
            int newY= y + dy[direction];

            // 청소 가능
            if (isInsideBoard(newX, newY) && board[newY][newX] == 0) {
                cnt++;
                dfs(newX, newY, direction);

                return;
            }
        }

        int back = (direction + 2) % 4;
        int backX = x + dx[back];
        int backY = y + dy[back];

        if (isInsideBoard(backX, backY) && board[backY][backX] != 1) {
            dfs(backX, backY, direction);
        }
    }

    static boolean isInsideBoard(int x, int y) {
        if (x < 0 || x >= col || y < 0 || y >= row) {
            return false;
        }
        return true;
    }
}
