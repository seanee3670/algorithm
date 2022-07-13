package cumulativeSum;

import java.io.*;
import java.util.StringTokenizer;

public class RemainderSum {

    static int[] arr;
    static Integer[] dp;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        arr = new int[N + 1];
        dp = new Integer[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        dp[N] = 0;

        for (int i = N; i > 0; i--) {
            findRemainderSum(i);
        }
        try {
//            System.out.println(dp[N]);
            System.out.println(Boolean.compare(isDivisible(arr[N], M), true));

        } catch (Exception e) {
            System.out.println("error");
            throw e;
        }

    }



    // rule 1: 연속되어야함 -->
    // rule 2: M으로 나눠떨어져야 함 --> 0은 안됨
    static int findRemainderSum(int N) {
        if (dp[N] == null) {
            // initialize dp[N] either 1 or 0 based on 'isDivisible'
            dp[N] = Boolean.compare(isDivisible(arr[N], M), true);

            for (int i = 0; i < N; i++) {
                dp[N] += Boolean.compare(isDivisible(recur(N, i), M), true);
            }
        }

        return dp[N];
    }

    static int recur(int N, int endPoint) {
        if (N == endPoint ) {
            return arr[N];
        }

        return arr[N] + recur(N - 1, endPoint);
    }

    static boolean isDivisible(int N, int M) {

        if (N == 0) {
            return false;
        }

        if (N % M == 0) {
            return true;
        }
        return false;
    }
}
