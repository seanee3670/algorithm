import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 { // 전쟁 - 전투
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static char[][] arr;
    static int row;
    static int col;
    static long numWhite = 0;
    static long numBlue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        visited = new boolean[col][row];
        arr = new char[col][row];

        for (int i = 0; i < col; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < row; j++) {
                arr[i][j] = chArr[j];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (visited[i][j]) {
                    continue;
                }
                bfs(j, i, arr[i][j]);
            }
        }

        System.out.println(numWhite + " " + numBlue);
    }

    static void bfs(int x, int y, char ch) {
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{x, y});

        long answer = 0;
        while (!q.isEmpty()) {
            int[] temp = q.remove();
            answer++;

            for (int i = 0; i < dx.length; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];
                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }

                if (visited[newY][newX] || arr[newY][newX] != ch) {
                    continue;
                }

                q.add(new int[]{newX, newY});
                visited[newY][newX] = true;
            }
        }

//        if (ch == 'B') {
//            System.out.println(answer);
//        }
        if (ch == 'W') {
            numWhite += (answer * answer);
        } else {
            numBlue += (answer * answer);
        }
    }
}
