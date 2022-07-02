package DP;

import java.io.*;

public class GoingUpStairs {

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int N = Integer.valueOf(br.readLine());
        arr = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(GetMaxOfStairs(N));
    }

    public static int GetMaxOfStairs(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(GetMaxOfStairs(N - 2), GetMaxOfStairs(N - 3) + arr[N - 1]) + arr[N];
        }

        return dp[N];
    }
}
