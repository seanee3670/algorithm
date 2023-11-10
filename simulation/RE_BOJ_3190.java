import java.io.*;
import java.util.*;

public class RE_BOJ_3190 { // 뱀
    static enum Value {EMPTY, SNAKE, APPLE;}

    static int[] dx = {1, 0, -1, 0}; // r, d, l, u
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        board = new int[N][N];
        int numApp = Integer.valueOf(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < numApp; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken()) - 1;
            int b = Integer.valueOf(st.nextToken()) - 1;

            board[a][b] = Value.APPLE.ordinal();
        }

        int ordersLen = Integer.valueOf(br.readLine());
        int[][] orders = new int[ordersLen][2];
        for (int i = 0; i < ordersLen; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.valueOf(st.nextToken());
            int order = st.nextToken().equals("D") ? 1 : -1;

            orders[i][0] = time;
            orders[i][1] = order;
        }


        int dir = 0;
        int timeIdx = 0;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[]{0, 0});
        board[0][0] = Value.SNAKE.ordinal();

        int answer = 0;
        while (true) {
            answer++;
            // 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            int[] temp = snake.peekFirst();

            int newX = temp[0] + dx[dir];
            int newY = temp[1] + dy[dir];

            // 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
            if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                break;
            }

            if (board[newY][newX] == Value.SNAKE.ordinal()) {
                break;
            }

            //만약 이동한 칸에 사과가 없다면
            if (board[newY][newX] == Value.EMPTY.ordinal()) {
                // 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다
                int[] tail = snake.removeLast();
                board[tail[1]][tail[0]] = Value.EMPTY.ordinal();
            }

            // 머리 증가
            snake.addFirst(new int[]{newX, newY});
            board[newY][newX] = Value.SNAKE.ordinal();

            // 방향 전환
            if (timeIdx < ordersLen && answer == orders[timeIdx][0]) {
                dir = (dir + orders[timeIdx][1] + dx.length) % dx.length;
                timeIdx++;
            }

//            printBoard();
//            System.out.println();
        }

        System.out.println(answer);

    }

    static void printBoard() {
        for (int[] arr : board) {
            for (var b : arr) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
