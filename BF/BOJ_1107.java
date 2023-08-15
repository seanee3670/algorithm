import java.io.*;
import java.util.*;
public class BOJ_1107 { // 리모컨
    static final int START = 100;
    static final int LIMIT = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.valueOf(br.readLine());

        int N = Integer.valueOf(br.readLine());
        boolean[] isBroken = new boolean[10];
        if (N != 0) {
            String[] info = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                isBroken[Integer.valueOf(info[i])] = true;
            }
        }

        int min = Math.abs(target - 100);

        min = Math.abs(target - START); // 100에서 이동한 숫자
        for (int i = 0; i < LIMIT; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (isBroken[str.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            int temp = Math.abs(target - i) + len;
            min = Math.min(min, temp);
        }

        System.out.println(min);

    }

}
