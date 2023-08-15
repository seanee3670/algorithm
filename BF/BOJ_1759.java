import java.io.*;
import java.util.*;

public class BOJ_1759 { // 암호 만들기
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb = new StringBuilder();
    static String[] arr;
    static boolean[] visited;
    static int lenCode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        lenCode = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());

        arr = new String[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        visited = new boolean[N];
        dfs("", 0);
        System.out.println(sb.toString());

    }

    static void dfs(String str, int idx) {
        if (str.length() == lenCode && isWord(str)) {
            sb.append(str + '\n');
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (visited[i]) { //
                continue;
            }
            visited[i] = true;
            dfs(str + arr[i], i + 1);
            visited[i] = false;
        }
    }

    static boolean isWord(String str) {
        // 최소 모음 한개, 자음 최소 두개
        int cntVowels = 0;
        for (char ch : str.toCharArray()) {
            for (char vowel : vowels) {
                if (ch == vowel) {
                    cntVowels++;
                    break;
                }
            }
        }

        if (cntVowels > 0 && cntVowels <= str.length() - 2) {
            return true;
        }

        return false;
    }
}
