import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RERE_BOJ_2293 { // 동전 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        int[] dp = new int[target + 1];
        int max = -1;
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i += coin) {
                dp[i]++;
                max = Math.max(max, dp[i]);
            }
        }

        System.out.println(max);


    }
}
