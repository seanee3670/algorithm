package DP;

import java.io.*;

public class GoingUpStairsMyAttempt {

    static int N;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        N = Integer.valueOf(br.readLine().trim());
        arr = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(br.readLine().trim());
        }

        dp[N - 1] = arr[N - 1];

        System.out.println(GetMaxOfStairs(1, 0) + arr[0]);
    }

    public static int GetMaxOfStairs(int idx, int cnt) {
        if (idx == N - 1) {
            return dp[N - 1];
        }

        if (idx > N - 1) {
            return 0;
        }

        if (dp[idx] == null) {
            if (cnt == 0) {
                dp[idx] = Math.max(GetMaxOfStairs(idx + 1, cnt + 1), GetMaxOfStairs(idx + 2, 0)) + arr[idx];
            } else if (cnt == 1) {
                dp[idx] = GetMaxOfStairs(idx + 2, 0) + arr[idx];
            }
        }

        return dp[idx];
    }
}
