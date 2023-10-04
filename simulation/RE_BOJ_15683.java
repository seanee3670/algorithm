import java.io.*;
import java.util.*;

public class RE_BOJ_15683 { // 감시
    static class CCTV {
        int x;
        int y;
        int type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        void work(int direction) {

            if (direction < 0 || direction >= LIMIT) {
                throw new IllegalArgumentException();
            }

            int type = this.type;

            if (type == 1) {
                monitor(direction);
            } else if (type == 2) {
                monitor(direction);
                monitor((direction + 2) % LIMIT);
            } else if (type == 3) {
                monitor(direction);
                monitor((direction + 1) % LIMIT);
            } else if (type == 4) {
                monitor(direction);
                monitor((direction + 1) % LIMIT);
                monitor((direction + 3) % LIMIT);
            } else if (type == 5) {
                for (int i = 0; i < LIMIT; i++) {
                    monitor(i);
                }
            }
        }
        void monitor(int direction) {
            boolean[][] visited = new boolean[row][col];

            q.clear();
            q.add(this);
            visited[this.y][this.x] = true;

            while (!q.isEmpty()) {
                CCTV temp = q.remove();
                int newX = temp.x + directions[direction][0];
                int newY = temp.y + directions[direction][1];

                if (newX < 0 || newX >= col || newY < 0 || newY >= row || boardCopy[newY][newX] == 6) {
                    break;
                }

                if (boardCopy[newY][newX] == 0) {
                    boardCopy[newY][newX] = -1; // can be monitored

                }
                q.add(new CCTV(newX, newY, this.type));
            }
        }



    }
    static int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // N, E, S, W
    static final int LIMIT = directions.length;
    static List<CCTV> list = new ArrayList<>();
    static Queue<CCTV> q = new LinkedList<>();
    static int[][] boardCopy;
    static int[][] board;
    static int[] nextDirections;
    static int N = 0;
    static int row;
    static int col;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        board = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
                if (board[i][j] == 0 || board[i][j] == 6) {
                    continue;
                }
                list.add(new CCTV(j, i, board[i][j]));
            }
        }

        N = list.size();
        nextDirections = new int[N];

        permutation(0);

        System.out.println(min);


    }
    static void permutation(int depth) {
        if (depth == N) {
            // clone the board
            boardCopy = new int[row][col];
            for (int i = 0; i < row; i++) {
                boardCopy[i] = board[i].clone();
            }

            for (int i = 0; i < list.size(); i++) {
                list.get(i).work(nextDirections[i]);
            }

            min = Math.min(min, getBlindSpot());
            return;

        }
        for (int i = 0; i < 4; i++) {
            nextDirections[depth] = i;
            permutation(depth + 1);
        }
    }

    static int getBlindSpot() {
        int cnt = 0;
        for (int[] arr : boardCopy) {
            for (int sqr : arr) {
                if (sqr == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }



}





