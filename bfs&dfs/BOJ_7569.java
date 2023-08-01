import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 { // 토마토
    static class Tomato {
        int x;
        int y;
        int z;

        Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[][][] tomatoes;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int row;
    static int col;
    static int height;
    static Queue<Tomato> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());
        height = Integer.valueOf(st.nextToken());

        tomatoes = new int[height][col][row];

        // receive input for tomatoes array
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < col; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < row; k++) {
                    tomatoes[i][j][k] = Integer.valueOf(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        q.add(new Tomato(k, j, i));
                    }
                }
            }
        }

        bfs();

        System.out.println(getMax());

    }
    static void bfs() {
        while (!q.isEmpty()) {
            Tomato temp = q.remove();

            for (int i = 0; i < dx.length; i++) {
                int newX = temp.x + dx[i];
                int newY = temp.y + dy[i];
                int newZ = temp.z + dz[i];

                // check range validity
                if (newX < 0 || newX >= row || newY < 0 || newY >= col || newZ < 0 || newZ >= height) {
                    continue;
                }

                if (tomatoes[newZ][newY][newX] == 0) {
                    q.add(new Tomato(newX, newY,newZ));

                    tomatoes[newZ][newY][newX] = tomatoes[temp.z][temp.y][temp.x] + 1;
                }
            }
        }
    }

    static int getMax() {
        int max = Integer.MIN_VALUE;

        for (int[][] twoDiArray : tomatoes) {
            for (int[] arr : twoDiArray) {
                for (int tomato : arr) {
                    if (tomato == 0) {
                        return -1;
                    }
                    max = Math.max(max, tomato);
                }
            }
        }
        return max == 1 ? 0 : max - 1;
    }
}
