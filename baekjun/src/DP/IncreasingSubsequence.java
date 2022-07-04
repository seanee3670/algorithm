package DP;

import java.io.*;
import java.util.StringTokenizer;

public class IncreasingSubsequence {
    // Often called as LIS(Longest Increasing Subsequence)

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int numOfElements = Integer.valueOf(br.readLine());
        arr = new int[numOfElements];
        dp = new Integer[numOfElements];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < numOfElements; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for (int i = 0; i < numOfElements; i++) {
            countIncreasingSubsequence(i);
        }

        // find max from dp[]
        int max = dp[0];
        for (int i = 1; i < numOfElements; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

    public static int countIncreasingSubsequence (int N) {
        if (dp[N] == null) {
            // 모든 수열은 최소 1이므로.
            dp[N] = 1;

            for (int i = N - 1; i >= 0; i--) { // N == 0 이라면 실행 x
                if (arr[N] > arr[i]) {
                    dp[N] = Math.max(dp[N], countIncreasingSubsequence(i) + 1); // 크면 + 1 해야하므로
                }
            }
        }
        return dp[N];
    }

}
