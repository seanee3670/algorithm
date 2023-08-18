import java.io.*;

public class RE_BOJ_1107 { // 리모컨
    static final int START = 100;
    static final int LIMIT = 999999; // 999,999
    static boolean[] isBroken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.valueOf(br.readLine());

        int N = Integer.valueOf(br.readLine());
        if (N != 0) {
            String[] info = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                isBroken[Integer.valueOf(info[i])] = true;
            }
        }

        int min = Math.abs(target - START);
        for (int num = 0; num <= LIMIT; num++) {
            String channel = String.valueOf(num);
            if (containsBrokenButton(channel)) {
                continue;
            }
            min = Math.min(min, Math.abs(target - num) + channel.length()); // 채널 차이 + 채널 숫자 갯수
        }

        System.out.println(min);

    }

    static boolean containsBrokenButton(String channel) {
        for (char ch : channel.toCharArray()) {
            if (isBroken[ch - '0']) {
                return true;
            }
        }
        return false;
    }
}
