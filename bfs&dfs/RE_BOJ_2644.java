import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RE_BOJ_2644 {
    static int[][] connection;
    static int[] d; // start 기준으로 몇촌씩 차이나는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        connection = new int[N + 1][N + 1];
        d = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        int M = Integer.valueOf(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            connection[a][b] = 1;
            connection[b][a] = 1;
        }
        bfs(start, target);

        int answer = d[target] == 0 ? -1 : d[target];
        System.out.println(answer);


    }
    static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int temp = q.remove();

            // 타겟을 만나면 종료
            if (temp == target) {
                break;
            }

            for (int i = 1; i < connection.length; i++) {
                // 이미 계산한 촌수거나 연결되어 있지 않다면 스킵
                if (d[i] != 0 || connection[temp][i] != 1) {
                    continue;
                }
                q.add(i);
                d[i] = d[temp] + 1;
            }
        }
    }
}
