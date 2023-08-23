import java.io.*;
import java.util.*;

public class RE_BOJ_2667 { // 단지번호붙이기
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static int N;
    static List<Integer> list = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                bfs(j, i);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer cnt : list) {
            System.out.println(cnt);
        }

    }
    static void bfs(int x, int y) {
        q.clear();
        q.add(new int[]{x, y});
        board[y][x] = 0;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] temp = q.remove();

            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    continue;
                }
                if (board[newY][newX] == 0) {
                    continue;
                }
                board[newY][newX] = 0;
                q.add(new int[]{newX, newY});
                cnt++;
            }

        }
        list.add(cnt);
    }
}
