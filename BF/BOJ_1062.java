import java.io.*;
import java.util.*;

public class BOJ_1062 { // 가르침
    static boolean[] visited = new boolean[26];
    static String[] words;
    static int max = 0;
    static int N;
    static int limit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        limit = Integer.valueOf(st.nextToken());


        words = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            words[i] = str;
        }

        System.out.println(calcMax());

    }

    static int calcMax() {
        if (limit < 5) {
            return 0;
        } else if (limit == 26) {
            return N;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        limit -= 5;

        dfs(0, 0);
        return max;
    }

    static boolean isReadable(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!visited[word.charAt(i) - 'a']) {
                return false;
            }
        }

        return true;
    }

    static void dfs(int start, int depth) {
        if (depth == limit) {
            int cnt = 0;
            for (String word : words) {
                if (isReadable(word)) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i, depth + 1);
            visited[i] = false;
        }
    }
}
