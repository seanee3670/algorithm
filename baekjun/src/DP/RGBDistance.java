package DP;

import java.io.*;
import java.util.StringTokenizer;

public class RGBDistance {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    static int[][] cost;
    static  int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.valueOf(br.readLine());

        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            cost[i][RED] = Integer.valueOf(st.nextToken());
            cost[i][GREEN] = Integer.valueOf(st.nextToken());
            cost[i][BLUE] = Integer.valueOf(st.nextToken());
        }


        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(paintCost(N - 1, RED), Math.min(paintCost(N - 1, GREEN), paintCost(N - 1, BLUE))));

    }

    public static int paintCost(int N, int color) {
        if (dp[N][color] == 0) {
            if (color == RED) {
                dp[N][RED] = Math.min(paintCost(N - 1, GREEN), paintCost(N - 1, BLUE)) + cost[N][RED];
            }
            else if (color == GREEN) {
                dp[N][GREEN] = Math.min(paintCost(N - 1, RED), paintCost(N - 1, BLUE)) + cost[N][GREEN];
            }
            else if (color == BLUE) {
                dp[N][BLUE] = Math.min(paintCost(N - 1, RED), paintCost(N - 1, GREEN)) + cost[N][BLUE];
            }
        }

        return dp[N][color];
    }
}
