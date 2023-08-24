import java.io.*;
import java.util.*;

public class RE_BOJ_1697 { // 숨바꼭질
    static int min = Integer.MAX_VALUE;
    static int LIMIT = 100000 * 2;
    static int[] visited = new int[LIMIT + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        if (start == target) {
            min = 0;
        } else {
            bfs(start, target);
        }

        System.out.println(min);


    }

    static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int temp = q.remove();
            if (temp == target) {
                 min = visited[target] - 1;
                 return;
            }
            // 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X
            if (temp - 1 >= 0 && visited[temp - 1] == 0) {
                visited[temp - 1] = visited[temp] + 1;
                q.add(temp - 1);
            }

            if (temp + 1 < LIMIT && visited[temp + 1] == 0) {
                visited[temp + 1] = visited[temp] + 1;
                q.add(temp + 1);
            }

            if (temp * 2 < LIMIT && visited[temp * 2] == 0) {
                visited[temp * 2] = visited[temp] + 1;
                q.add(temp * 2);
            }
        }

    }
}
