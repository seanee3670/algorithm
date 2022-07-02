package DP;

import java.io.*;

public class EasyNumOfStairs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제: N만큼 긴 수에 계단수(각 자리수 차이가 1, 순서 상관x)가 몇 개 있을까 (에 1,000,000,000을 나눈 나머지)
        int N = Integer.valueOf(br.readLine());

        // 1 -> 1 ~ 9
        /* 2 ->
        10, 12
        21, 23..
        87, 89
        98..끝
        2 * 8 + 1 = 17 (답 맞음)
        뭘 메모이제이션 해야할까? -> 숫자마다의 계단수. 1-> 9, 2 -> 99, 3 -> 999
ddd
        // 자릿수 9로 맞추기
        int num = 1;
        for (int i = 0; i < N; i++) {
            num *= 10;
        }
        num--;


        public static int stairsNum(int N, int numDigits) {
            // 안되는 상황
            1) N < 1 -> 1은 뭘로 비교..? ( return)
            2) 두 자리 차이 =! 1 || =! -1



            if (dp[N] == null) {

            }

            return dp[N];

            // 숫자를 증가/감소.. 자릿수 고려..
            if (
        }
                d*/
    }
}
