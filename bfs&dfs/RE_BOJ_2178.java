import java.io.*;
import java.util.*;

public class RE_BOJ_2178 { // 미로 탐색
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row;
    static int col;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        board = new int[row][col];
        for (int i = 0; i < row; i++) {
            String info = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = Character.getNumericValue(info.charAt(j));
            }
        }

        bfs();
        System.out.println(board[row - 1][col - 1]);

    }
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                if (newX < 0 || newX >= col || newY < 0 || newY >= row) {
                    continue;
                }


                if (board[newY][newX] == 0 || board[newY][newX] > 1) {
                    continue;
                }

                board[newY][newX] = board[temp[1]][temp[0]] + 1;
                if (newX == col - 1 && newY == row - 1) { // reached target
                    break;
                }
                q.add(new int[]{newX, newY});
            }
        }
    }
}
