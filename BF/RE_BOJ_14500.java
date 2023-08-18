import java.util.*;
import java.io.*;

public class RE_BOJ_14500 { // (복습) 테트로미노
    static final int SIZE = 4;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row;
    static int col;
    static int[][] board;
    static boolean[][] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        visited = new boolean[row][col];
        board = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                dfs(j, i, 1, board[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);


    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == SIZE) {
            max = Math.max(max, sum);
            return;
        } else if (depth == 2) {
            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= col || newY < 0 || newY >= row) {
                    continue;
                }
                if (visited[newY][newX]) {
                    continue;
                }
                visited[newY][newX] = true;
                dfs(x, y, depth + 1, sum + board[newY][newX]);
                visited[newY][newX] = false;
            }
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
            visited[newY][newX] = true;
            dfs(newX, newY, depth + 1, sum + board[newY][newX]);
            visited[newY][newX] = false;
        }
    }
}
