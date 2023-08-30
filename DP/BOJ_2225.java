import java.io.*;
import java.util.*;

public class BOJ_2225 { // 합분해
    static final int DIVIDER = 1000000000;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        dp = new int[K + 1][N + 1];
        Arrays.fill(dp[1], 1);

        for (int depth = 2; depth <= K; depth++) {
            for (int num = 0; num <= N; num++) {
                for (int temp = 0; temp <= num; temp++) {
                    dp[depth][num] += dp[depth - 1][temp];
                    dp[depth][num] %= DIVIDER;
                }
            }
        }

        System.out.println(dp[K][N]);
    }

}
