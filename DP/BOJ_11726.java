import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 { // 2 x n  타일링
    static final int DIVIDER = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int a = 1;
        int b = 2;

        int answer = 0;
        if (N == 1) {
            answer = a;
        } else if (N == 2) {
            answer = b;
        } else {
            for (int i = 3; i <= N; i++) {
                answer = (a + b) % DIVIDER;
                a = b;
                b = answer;
            }
        }

        System.out.println(answer);

    }
}
