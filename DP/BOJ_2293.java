import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 { // 동전 1
    static int[] coins;
    static int[] dp;
    static int target;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        target = Integer.valueOf(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        dp = new int[target + 1];
        dp[0] = 1;

        // 점화식: dp[i] = dp[i] + dp[i - coins[i]]
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[target]);

    }
}
