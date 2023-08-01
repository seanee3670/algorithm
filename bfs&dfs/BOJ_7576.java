import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int row;
    static int col;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        row = Integer.valueOf(info[0]);
        col = Integer.valueOf(info[1]);

        // get 'board' input && add 1s to q
        board = new int[col][row];
        StringTokenizer st;
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
                if (board[i][j] == 1) {
                    q.add(new int[]{j, i});
                }
            }
        }

//        printBoard();

        // 며칠쨰 된 익은 토마토가 안익은 토마토를 익게 하는지 기록
        bfs();

        int answer = 0;
        // 안익은 토마토가 있는지 체크
        if (checkZero()) {
            answer = -1;
        } else {
        // 없다면 최댓값 기록
            answer = getMax() - 1;
        }

        System.out.println(answer);




    }
    static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            // 4 방향 탐색
            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                // 유효성 검사
                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }

                // 안익은 토마토 익히기
                if (board[newY][newX] == 0) {
                    board[newY][newX] = board[temp[1]][temp[0]] + 1;
                    q.add(new int[]{newX, newY});
                }
            }
        }
    }

    static boolean checkZero() {
        for (int[] arr : board) {
            for (int tomato : arr) {
                if (tomato == 0) { // 안 익었다면
                    return true;
                }
            }
        }
        return false;
    }

    static int getMax() {
        int max = Integer.MIN_VALUE;
        for (int[] arr : board) {
            for (int tomato : arr) {
                max = Math.max(max, tomato);
            }
        }
        return max;
    }

    static void printBoard() {
        for (int[] arr : board) {
            for (int tomato : arr) {
                System.out.print(tomato + " ");
            }
            System.out.println();
        }
    }
}
