import java.io.*;
import java.util.*;

public class RE_BOJ_2225 { // 합분해
    static int[][] dp;
    static final int LIMIT = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        // 0 ~ N 까지 정수 K 개를 더해서 N을 만드는 경우의 수
        dp = new int[N + 1][K + 1];
        /*
        3 1 -> 3
        3 2 -> 03 12 21 30
        3 3 -> 003 012 021 102 111 120 210 201 300
         */

        for (int j = 0; j <= N; j++) {
            dp[j][1] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[j][i] += dp[k][i - 1];
                    dp[j][i] %= LIMIT;
                }
            }
        }

        System.out.println(dp[N][K]);

    }

}
