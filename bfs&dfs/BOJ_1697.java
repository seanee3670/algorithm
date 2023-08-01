import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 { // 숨바꼭질
    static int[] dp;
    static int start;
    static int target;
    static final int LIMIT = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.valueOf(st.nextToken());
        target = Integer.valueOf(st.nextToken());

        int answer = 0;

        if (start != target) {
            // 해당 위치까지 가는데 걸리는 최소 시간
            dp = new int[LIMIT * 2 + 1];
            bfs(start);
            answer = dp[target];
        }

        System.out.println(answer);
    }

    static void bfs(int cur) {
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);

        while (!q.isEmpty()) {
            int temp = q.remove();

            // + 1
            if (temp + 1 < dp.length && dp[temp + 1] == 0) {
                dp[temp + 1] = dp[temp] + 1;
                if (temp + 1 == target) {
                    break;
                }
                q.add(temp + 1);
            }

            // -1
            if (temp - 1 >= 0 && dp[temp - 1] == 0) {
                dp[temp - 1] = dp[temp] + 1;
                if (temp - 1 == target) {
                    break;
                }
                q.add(temp - 1);
            }

            // * 2
            if (temp * 2 < dp.length && dp[temp * 2] == 0) {
                dp[temp * 2] = dp[temp] + 1;
                if (temp * 2 == target) {
                    break;
                }
                q.add(temp * 2);
            }
        }
    }
}
