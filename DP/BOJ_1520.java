import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 { // 내리막 길
    static int[][] arr;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0,0));
    }

    static int dfs(int x, int y) {
        if (x == dp[0].length - 1 && y == dp.length - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        dp[y][x] = 0;
        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= dp[0].length || newY < 0 || newY >= dp.length) {
                continue;
            }

            if (arr[y][x] > arr[newY][newX]) {
                dp[y][x] += dfs(newX, newY);
            }
        }
        return dp[y][x];
    }
}
