import java.io.*;
import java.util.*;

public class RE_BOJ_18352 { // 특정 거리의 도시 찾기
    static List<Integer>[] routes;
    static int[] distances;
    static int start;
    static int numOfCities;
    static int d;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numOfCities = Integer.valueOf(st.nextToken());
        int numOfRoutes = Integer.valueOf(st.nextToken());
        d = Integer.valueOf(st.nextToken());
        start = Integer.valueOf(st.nextToken());

        routes = new List[numOfCities + 1];

        distances = new int[numOfCities + 1];
        Arrays.fill(distances, -1);

        for (int i = 1; i <= numOfCities; i++) { // init routes
            routes[i] = new ArrayList<>();
        }
        for (int i = 0; i < numOfRoutes; i++) {
            st = new StringTokenizer(br.readLine());
            Integer a = Integer.valueOf(st.nextToken());
            Integer b = Integer.valueOf(st.nextToken());
            routes[a].add(b);
        }

        bfs();
        answer.sort(Integer::compareTo);
        StringBuilder sb = new StringBuilder();
        for (int route : answer) {
            sb.append(route).append('\n');
        }
        System.out.println(sb.length() == 0 ? -1 : sb.toString());


    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        distances[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int temp = q.remove();
            if (distances[temp] > d) {
                break;
            } else if (distances[temp] == d) {
                answer.add(temp);
            }

            for (int next : routes[temp]) {
                if (distances[next] != -1) {
                    continue;
                }
                distances[next] = distances[temp] + 1;
                q.add(next);
            }

        }

    }
}
