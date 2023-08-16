import java.util.*;
import java.io.*;

public class BOJ_10819 {
    static int max = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(1, i, 0);
            visited[i] = false;
        }

        System.out.println(max);


    }

    static void dfs(int depth, int idx, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, i, sum + Math.abs(arr[idx] - arr[i]));
            visited[i] = false;
        }
    }
}
