import java.io.*;

public class BOJ_2133 { // 타일 채우기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int answer = 0;
        if (N % 2 == 0) {
            int[] dp = new int[N + 1];
            dp[0] = 1;
            dp[2] = 3;

            for (int i = 4; i <= N; i += 2) {
                dp[i] = dp[i - 2] * dp[2];
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] = dp[i] + (dp[j] * 2);
                }
            }

            answer = dp[N];
        }

        System.out.println(answer);
    }
}
