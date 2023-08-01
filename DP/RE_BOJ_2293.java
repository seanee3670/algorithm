import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_BOJ_2293 { // 동전 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        int[] dp = new int[target + 1];
        dp[0] = 1;

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        // dp[i] += dp[i - coin];
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[target]);
    }
}
