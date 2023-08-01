import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 { // 특정 거리의 도시 찾기
    static List<Integer>[] edges;
    static boolean[][] connected;
    static boolean[] visited;
    static int[] d = new int[300001];
    static int targetDistance;
    static int start;
    static int numOfCities;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numOfCities = Integer.valueOf(st.nextToken());
        int numOfRoutes = Integer.valueOf(st.nextToken());
        targetDistance = Integer.valueOf(st.nextToken());
        start = Integer.valueOf(st.nextToken());

        edges = new List[numOfCities + 1];
        connected = new boolean[numOfCities + 1][numOfCities + 1];
        for (int i = 0; i < numOfRoutes; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            connected[a][b] = true;
        }

        bfs();

        String answer = sb.length() == 0 ? "-1" : sb.toString();

        System.out.println(answer);

    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            if (temp[1] == targetDistance) { // 최단거리가 distance 와 같다면 추가
                sb.append(String.valueOf(temp[0]) + '\n');
                continue;
            }
            for (int i = 1; i <= numOfCities; i++) {
                // 방문했거나 연결되어있지 않다면 패스
                if (visited[i] || !connected[temp[0]][i]) {
                    continue;
                }
                q.add(new int[] {i, temp[1] + 1});
                visited[i] = true;
            }
        }
    }
}
