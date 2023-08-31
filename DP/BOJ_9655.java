import java.io.*;
import java.util.*;

public class BOJ_9655 { // 돌 게임
    static final String SANGKEUN = "SK";
    static final String CHANGYOUNG = "CY";
    static boolean[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        dp = new boolean[N + 1];

        String answer;

        if (N % 2 == 0) {
            answer = CHANGYOUNG;
        } else {
            answer = SANGKEUN;
        }

        System.out.println(answer);
    }


}
