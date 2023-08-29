import java.util.*;
import java.io.*;

public class BOJ_2294 { // 동전 2
    static int[] dp;
    static final int LIMIT = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        dp = new int[target + 1];

        Arrays.fill(dp, LIMIT);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                System.out.println(dp[i]);
            }
        }

        System.out.println(dp[target] == LIMIT ? -1 : dp[target]);
    }

}
