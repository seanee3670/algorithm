import java.io.*;
import java.util.*;
public class BOJ_1107 { // 리모컨
    static int[] nums = new int[10];
    static boolean[] isBroken = new boolean[10];
    static int min;
    static String strTarget;
    static int intTarget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strTarget = br.readLine();
        intTarget = Integer.valueOf(strTarget);

        int N = Integer.valueOf(br.readLine());
        if (N != 0) {
            String[] infos = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                isBroken[Integer.valueOf(infos[i])] = true;
            }
        }

        initNums();
        min = Math.abs(100 - intTarget); // 100에서 이동한 숫자
        dfs(0, 0);
        // 한자리 수 위에서 시작
        int biggerNum = createBiggerNum();
        if (biggerNum > 0) {
            dfs(biggerNum, strTarget.length() + 1);
        }

        System.out.println(min);

    }
    static void dfs(int cur, int cnt) {
        if (cnt >= strTarget.length()) { // +, - 로 이동
            min = Math.min(min, Math.abs(cur - intTarget) + cnt);
            return;
        }
        int candidate = strTarget.charAt(cnt) - '0';
        // 누를 수 있다면
        if (!isBroken[candidate]) {
            dfs(cur * 10 + candidate, cnt + 1);
        }
        else {
            for (int num : nums) {
                if (isBroken[num]) {
                    continue;
                }
                dfs(cur * 10 + num, cnt + 1);

            }
        }

    }

    static void initNums() {
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }
    }
    static int createBiggerNum() {
        // 0 이 아닌 최소 숫자
        int num = -1;
        for (int i = 1; i < nums.length; i++) {
            if (isBroken[i]) {
                continue;
            }
            num = nums[i];
            break;
        }
        // 0 을 포함한 최소 숫자
        int adder = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isBroken[i]) {
                continue;
            }
            num = nums[i];
            break;
        }
        if (num == -1 && adder == -1) { // 모든 키가 망가졌을때 -1 반환
            return -1;
        }

        for (int i = 0; i < intTarget; i++) {
            num = num * 10 + adder;
        }
        return num;
    }

}
