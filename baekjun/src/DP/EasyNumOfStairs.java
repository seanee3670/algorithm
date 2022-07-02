package DP;

import java.io.*;

public class EasyNumOfStairs {

    static Long[][] dp;
    static int N;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제: N만큼 긴 수에 계단수(각 자리수 차이가 1, 순서 상관x)가 몇 개 있을까 (에 1,000,000,000을 나눈 나머지)
        int N = Integer.valueOf(br.readLine());
        dp = new Long[N + 1][10];

        // 첫 자릿수를 1로 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        // 마지막 자릿수 1~9까지 경우의 수를 더함
        for (int i = 1; i <= 9; i++) {
            result += recur(N, i);
        }

        System.out.println(result % MOD);
    }

    static long recur(int digit, int val) {
        // 자릿수 한개면 탐색 x
        if (digit == 1) {
            return dp[digit][val];
        }

        if (dp[digit][val] == null) {
            // 0이면 뒤 숫자는 1만 가능
            if (val == 0) {
                dp[digit][val] = recur(digit - 1, 1);
            // 9라면 뒤 숫자는 8만 가능
            } else if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8);
            }
            else {
                dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
            }
        }
        return dp[digit][val] % MOD;
    }
}
