import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 { // 알파벳
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int col;
    static int row;
    static char[][] arr;
    static boolean[] abc = new boolean[26];
    static int max = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.valueOf(st.nextToken());
        row = Integer.valueOf(st.nextToken());

        arr = new char[col][row];
        for (int i = 0; i < col; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < row; j++) {
                arr[i][j] = chArr[j];
            }
        }

        dfs(0, 0, 1);

        System.out.println(max);
    }

    static void dfs(int x, int y, int cnt) {

        max = Math.max(max, cnt);
//        System.out.println(set.size());

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }
            if (abc[arr[newY][newX]]) {
                continue;
            }
            abc[arr[newY][newX]] = true;
            dfs(newX, newY, cnt + 1);
            abc[arr[newY][newX]] = false;
        }
    }
}


