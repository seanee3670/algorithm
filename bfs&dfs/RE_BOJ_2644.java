import java.util.*;
import java.io.*;

public class RE_BOJ_2644 { // 촌수계산

    static boolean[][] connected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalNum = Integer.valueOf(br.readLine());
        int[] d = new int[totalNum + 1];
        connected = new boolean[totalNum + 1][totalNum + 1];
        visited = new boolean[totalNum + 1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        int N = Integer.valueOf(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            connected[a][b] = true;
            connected[b][a] = true;
        }

        System.out.println(bfs(start, target));

    }

    static int bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        visited[start] = true;
        while (!q.isEmpty()) {
            int[] temp = q.remove();
            for (int i = 0; i < connected.length; i++) {
                if (!connected[temp[0]][i] || visited[i]) {
                    continue;
                }

                if (i == target) {
                    return temp[1] + 1;
                }

                q.add(new int[] {i, temp[1] + 1});
                visited[i] = true;
            }
        }

        return -1;
    }
}