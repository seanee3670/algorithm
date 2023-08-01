import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 { // 미로 탐색
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int col;
    static int row;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.valueOf(st.nextToken());
        row = Integer.valueOf(st.nextToken());

        board = new int[col][row];

        for (int i = 0; i < col; i++) {
            String str = br.readLine();
            for (int j = 0; j < row; j++) {
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        bfs();

        System.out.println(board[col - 1][row - 1]);

    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }

                if (board[newY][newX] == 0 || board[newY][newX] != 1) {
                    continue;
                }

                board[newY][newX] = board[temp[1]][temp[0]] + 1;
                q.add(new int[] {newX, newY});

            }

        }
    }
}

