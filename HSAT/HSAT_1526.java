import java.util.*;
import java.io.*;

public class HSAT_1526 { // [HSAT 6회 정기 코딩 인증평가 기출] 염기서열 커버
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> o2.compareTo(o1));
        // for (String str : arr) {
        //     System.out.print(str + " ");
        // }
        boolean[] deleted = new boolean[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (deleted[i]) {
                continue;
            }
            for (int j = 0; j < N; j++) {
                if (isSame(arr[i], arr[j])) {
                    deleted[j] = true;
                }
            }
            answer++;
        }

        System.out.println(answer);

    }

    static boolean isSame(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '.' || str2.charAt(i) == '.') {
                continue;
            }
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
