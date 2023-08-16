import java.util.*;
import java.io.*;

public class BOJ_14500 { // 테트로미노
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row;
    static int col;
    static int max = -1;
    static final int LIMIT = 4; // 테트로미노의 정사각형 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        board = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                dfs(j, i, board[i][j], 1);
                visited[i][j] = false;
            }

        }

        System.out.println(max);

    }

    static void dfs(int x, int y, int sum, int cnt) {
        if (cnt == LIMIT) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= col || newY < 0 || newY >= row) {
                continue;
            }
            if (visited[newY][newX]) {
                continue;
            }

            if (cnt == 2) { // ㅗ 형 테트로미노
                visited[newY][newX] = true;
                dfs(x, y, sum + board[newY][newX], cnt + 1);
                visited[newY][newX] = false;
            }
            visited[newY][newX] = true;
            dfs(newX, newY, sum + board[newY][newX], cnt + 1);
            visited[newY][newX] = false;
        }
    }
}
