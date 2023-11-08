import java.util.*;
import java.io.*;

public class ST_6289 { // 우물 안 개구리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int[] weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.valueOf(st.nextToken());
        }

//        boolean[][] isRelated = new boolean[N][N];
        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken()) - 1;
            int b = Integer.valueOf(st.nextToken()) - 1;
            friends.get(a).add(b);
            friends.get(b).add(a);
//            isRelated[a][b] = true;
//            isRelated[b][a] = true;
        }

        int cnt = N;
        loop:
        for (int i = 0; i < weights.length; i++) {
            for (var member : friends.get(i)) {
                if (weights[i] <= weights[member]) {
                    cnt--;
                    continue loop;
                }
            }
        }
        System.out.println(cnt);

    }
}
