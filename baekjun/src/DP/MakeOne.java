package DP;

import java.io.*;

public class MakeOne {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(getMinCal(N));
    }

    static int getMinCal(int N) {

        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(getMinCal(N / 3), Math.min(getMinCal(N / 2), getMinCal(N - 1))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(getMinCal(N / 3), getMinCal(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(getMinCal(N / 2), getMinCal(N - 1)) + 1;
            } else {
                dp[N] = getMinCal(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
