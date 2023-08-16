import java.util.*;
import java.io.*;

public class BOJ_14500 { // 테트로미노
    static List<Integer> list = new ArrayList<>();
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
                dfs(1, new int[]{j, i}, board[i][j]);
                visited[i][j] = false;
            }

            for (int k = 0; k < row; k++) { // visited 초기화
                Arrays.fill(visited[k], false);
            }
        }

        System.out.println(max);

    }


    static void dfs(int depth, int[] coordinate, int sum) {
        if (depth == LIMIT) {
            max = Math.max(max, sum);
            return;
        } else if (depth == 2) {
            list.clear();
            // 유효성 검사
            for (int i = 0; i < dx.length; i++) {
                int newX = coordinate[0] + dx[i];
                int newY = coordinate[1] + dy[i];

                if (newX < 0 || newX >= col || newY < 0 || newY >= row) {
                    continue;
                }

                if (visited[newY][newX]) {
                    continue;
                }

                visited[newY][newX] = true;
                list.add(board[newY][newX]);

            }
            max = Math.max(max, getMax());

        }
        // 유효성 검사
        for (int i = 0; i < dx.length; i++) {
            int newX = coordinate[0] + dx[i];
            int newY = coordinate[1] + dy[i];

            if (newX < 0 || newX >= col || newY < 0 || newY >= row) {
                continue;
            }

            if (visited[newY][newX]) {
                continue;
            }

            visited[newY][newX] = true;
            dfs(depth + 1, new int[]{newX, newY}, sum + board[newY][newX]);
            visited[newY][newX] = false;
        }


    }

    static int getMax() {
        int size = list.size();
        if (size == 0) {
            return 0;
        } else if (size == 1) {
            return list.get(0);
        } else if (size == 2) {
            return list.get(0) + list.get(1);
        }
        return Math.max(list.get(0) + list.get(1),
                Math.max(list.get(0) + list.get(2), list.get(1) + list.get(2)));
    }

}
