import java.io.*;

public class BOJ_12919 { // A와 B 2 (G5)
    static String S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();

        System.out.println(dfs(T));
    }

    static int dfs(String T) {
        if (T.length() == S.length()) {
            return T.equals(S) ? 1 : 0;
        }

        int answer = 0;
        if (T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(T.substring(1));
            answer += dfs(sb.reverse().toString());
        }

        if (T.charAt(T.length() - 1) == 'A') {
            answer += dfs(T.substring(0, T.length() - 1));
        }

        return answer >= 1 ? 1 : 0;
    }
}
