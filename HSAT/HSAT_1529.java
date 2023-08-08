import java.util.*;
import java.io.*;
public class HSAT_1529 { // HSAT 6회 정기 코딩 인증평가 기출] 출퇴근길
    static int n;
    static int m;
    static boolean[][] connected;
    static int start;
    static int end;
    static List<Integer> startRecord = new ArrayList<>();
    static List<Integer> endRecord = new ArrayList<>();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        boolean[] visited = new boolean[m + 1];
        connected = new boolean[m + 1][m + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            connected[Integer.valueOf(st.nextToken())][Integer.valueOf(st.nextToken())] = true;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.valueOf(st.nextToken());
        end = Integer.valueOf(st.nextToken());

        startRecordDfs(start, end, visited);
        endRecordDfs(end, start, visited);

        startRecord.retainAll(endRecord);
        for (int i : startRecord) {
            System.out.print(i + " ");
        }

        System.out.println(startRecord.size());

    }
    static void startRecordDfs (int cur, int target, boolean[] visited) {
        for (int i = 1; i <= m; i++) {
            if (!connected[cur][i] || visited[i]) {
                continue;
            }
            if (i == target) {

                for (int j = 1; j < visited.length; j++) {
                    if (visited[j] && !startRecord.contains(j)) {
                        startRecord.add(j);
                    }
                }
            }
            visited[i] = true;
            startRecordDfs(i, target, visited);
            visited[i] = false;
        }

    }
    static void endRecordDfs(int cur, int target, boolean[] visited) {
        for (int i = 1; i <= m; i++) {
            if (!connected[cur][i] || visited[i]) {
                continue;
            }
            if (i == target) {
                for (int j = 1; j < visited.length; j++) {
                    if (visited[j] && !endRecord.contains(j)) {
                        endRecord.add(j);
                    }
                }

            }
            visited[i] = true;
            endRecordDfs(i, target, visited);
            visited[i] = false;
        }
    }
}
