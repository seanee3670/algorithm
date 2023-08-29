import java.io.*;
import java.util.*;

public class BOJ_11066 { // 파일 합치기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            int M = Integer.valueOf(br.readLine());
            int[] arr = new int[M + 1];
            int[][] dp = new int[M + 1][M + 1];
            int[] sum = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[j] = Integer.valueOf(st.nextToken());
                sum[j] = sum[j - 1] + arr[j];
            }

            for (int j = 1; j <= M; j++) {
                for (int start = 1; start + j <= M; start++) {
                    int end = start + j;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int temp = start; temp < end; temp++) {
                        int tempValue = dp[start][temp] + dp[temp + 1][end] + sum[end] - sum[start - 1]; //
                        dp[start][end] = Math.min(dp[start][end], tempValue);
                    }

                }
            }

            sb.append(String.valueOf(dp[1][M]) + '\n');

        }

        System.out.println(sb.toString());
    }
}
