package DP;

import java.io.*;
import java.util.StringTokenizer;

public class IncreasingSubsequence {

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.valueOf(br.readLine());
        arr = new int[N + 1];
        dp = new Integer[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        arr[0] = Integer.MAX_VALUE;
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(countIncreasingSubsequence(N));
    }

    public static int countIncreasingSubsequence (int N){
        if (N <= 1) {
            return dp[N];
        }

        if (dp[N] == null) {
            for (int i = N - 1; i > 0; i--) {
                // 비교해야하는디
            dp[N] = Math.max(countIncreasingSubsequence(i), countIncreasingSubsequence(i - 1));
            }
        }

        return dp[N] += (arr[N] > arr[N - 1]) ? 1 : 0;
    }

}
