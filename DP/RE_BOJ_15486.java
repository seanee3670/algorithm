import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_BOJ_15486 { // 퇴사 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] costs = new int[N + 1];
        int[] revs = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.valueOf(st.nextToken());
            revs[i] = Integer.valueOf(st.nextToken());
        }
        int[] dp = new int[N + 2];

        int max = -1;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
            int day = i + costs[i];
            if (day >= dp.length) {
                continue;
            }

            dp[day] = Math.max(dp[day], max + revs[i]);
        }

        System.out.println(max);

    }
}
