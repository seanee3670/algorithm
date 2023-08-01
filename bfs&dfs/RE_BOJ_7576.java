import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RE_BOJ_7576 {
    static int col;
    static int row;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        row = Integer.valueOf(info[0]);
        col = Integer.valueOf(info[1]);

        board = new int[col][row];

        StringTokenizer st;
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }


        bfs();
//        printBoard();

        int answer = 0;
        if (checkZero()) {
            answer = -1;
        } else {
            answer = getMax();
        }

        System.out.println(answer);

    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        // 모든 1 삽입
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (board[i][j] == 1) {
                    q.add(new int[]{j, i});
                }
            }
        }

        // 1에 1씩 입히며 진행
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                // 유효성 검사
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                // 안익은 토마토만
                if (board[ny][nx] == 0) {
                    board[ny][nx] = board[temp[1]][temp[0]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean checkZero() {
        for (int[] arr : board) {
            for (int tomato : arr) {
                if (tomato == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getMax() {
        int max = Integer.MIN_VALUE;
        for (int[] arr : board) {
            for (int tomato : arr) {
                max = Math.max(max, tomato);
            }
        }
        return max - 1;
    }

    private static void printBoard() {
        for (int[] arr : board) {
            for (int tomato : arr) {
                System.out.print(tomato + " ");
            }
            System.out.println();
        }
    }
}
