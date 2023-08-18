import java.util.*;
import java.io.*;

public class RE_BOJ_1759 { // (복습)암호 만들기
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static int len;
    static String[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        len = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());

        arr = new String[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        dfs("", 0);

        System.out.println(sb.toString());

    }

    static void dfs(String str, int idx) {
        if (str.length() == len && isWord(str)) {
            sb.append(str + '\n');
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(str + arr[i], i + 1);
            visited[i] = false;
        }
    }

    static boolean isWord(String str) {
        int vowelCnt = 0;
        for (char ch : str.toCharArray()) {
            for (char vowel : vowels) {
                if (ch == vowel) {
                    vowelCnt++;
                    break;
                }
            }
        }

        // 모음 1개, 자음 2개 이상
        return vowelCnt > 0 && str.length() - vowelCnt >= 2;
    }
}
