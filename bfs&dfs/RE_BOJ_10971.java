import java.io.*;
import java.util.*;

public class RE_BOJ_10971 { // 외판원 순회 2
    static int N;
    static int[][] costs;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        StringTokenizer st;

        costs = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            start = i;
            visited[i] = true;
            dfs(i, 0, 1);
            visited[i] = false;
        }

        System.out.println(min);


    }

    static void dfs(int next, int cost, int depth) {
        if (depth == N && costs[next][start] != 0) {
            min = Math.min(min, cost + costs[next][start]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            if (costs[next][i] == 0) {
                continue;
            }

            visited[i] = true;
            dfs(i, cost + costs[next][i], depth + 1);
            visited[i] = false;
        }
    }
}
