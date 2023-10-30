import java.io.*;
public class RE_BOJ_9655 { // 돌 게임
    static final int LIMIT = 1000;
    static boolean[] wins = new boolean[LIMIT + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        String answer = battle(N) ? "SK" : "CY";
        System.out.println(answer);

    }

    static boolean battle(int N) {
        wins[1] = true;
        wins[2] = false;
        wins[3] = true;

        // 4 부터
        for (int i = 4; i <= N; i++) {
            wins[i] = !(wins[i - 1] || wins[i - 3]);
        }

        return wins[N];
    }
}
