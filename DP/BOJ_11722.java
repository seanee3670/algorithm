import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722 { // 가장 긴 감소하는 부분 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int max = 0;
        // 0 ~ last idx 까지 감소하는 부분수열의 길이 구한다
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 줄어든다면 dp[j] + 1 혹은 dp[i] 중 큰 값을 저장
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
