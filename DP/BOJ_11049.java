import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11049 { // 행렬 곱셈 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            arr[i] = a;
            arr[i + 1] = b;
        }

        int[][] dp = new int[N][N];
        int answer = Integer.MAX_VALUE;

        for (int i = 2; i < N + 1; i++) { // 구간 간격 i 
            for (int j = 0; j < N - i + 1; j++) { // 구간 시작점 j (0~j+i-1))
                dp[j][j + i - 1] = Integer.MAX_VALUE;
                for (int k = j; k < j + i - 1; k++) { // 중간 지점 k (j~ j+i-1)) 
                    int value = dp[j][k] + dp[k + 1][j + i - 1] + (arr[j] * arr[k + 1] * arr[j + i]);
                    dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], value);
                }
            }
        }

        System.out.println(dp[0][N - 1]);

    }
}
