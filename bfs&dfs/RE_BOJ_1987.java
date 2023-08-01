import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_BOJ_1987 {// 알파벳
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static boolean[] abc = new boolean[26];
    static int row;
    static int col;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.valueOf(st.nextToken());
        row = Integer.valueOf(st.nextToken());

        arr = new int[col][row];
        for (int i = 0; i < col; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < row; j++) {
                arr[i][j] = chArr[j] - 'A';
            }
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }
    static void dfs(int x, int y, int cnt) {
        if (abc[arr[y][x]]) {
            max = Math.max(max, cnt);
            return;
        }


        abc[arr[y][x]] = true;
        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }

            dfs(newX, newY, cnt + 1);
        }
        abc[arr[y][x]] = false;

    }

}
