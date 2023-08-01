import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 { // 외판원 순회2
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        arr = new int[N][N];
        boolean[] visited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        visited[0] = true;
        dfs(0, 1, 0, visited);
        System.out.println(answer);


    }

    static void dfs(int cur, int depth, int sum, boolean[] visited) {
//        System.out.println(sum);
        if (depth == arr.length) {
            // 마지막 순회
            if (arr[cur][0] != 0) {
                answer = Math.min(answer, sum + arr[cur][0]);
            }
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || arr[cur][i] == 0) {
                continue;
            }
            visited[i] = true;
            dfs(i, depth + 1, sum + arr[cur][i], visited);
            visited[i] = false;
        }
    }

}
