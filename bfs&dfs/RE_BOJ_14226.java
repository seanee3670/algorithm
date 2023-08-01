import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RE_BOJ_14226 { // 이모티콘
    static class Display {
        int num;
        int saved;
        int time;

        Display(int num, int saved, int time) {
            this.num = num;
            this.saved = saved;
            this.time = time;
        }
    }
    static final int LIMIT = 1000;
    static int[][] dp;
    static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.valueOf(br.readLine());

        dp = new int[LIMIT * 2 + 1][LIMIT * 2 + 1];

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Display> q = new LinkedList<>();
        q.add(new Display(1, 0, 0));

        while (!q.isEmpty()) {
            Display temp = q.remove();

            if (temp.num == target) {
                return temp.time;
            }

            // copy to clipboard(saved)
            if (dp[temp.num][temp.num] == 0) {
                dp[temp.num][temp.num] = temp.time + 1;
                q.add(new Display(temp.num, temp.num, temp.time + 1));
            }

            // paste from clipboard(saved) to display
            if (temp.num + temp.saved < dp.length && dp[temp.num + temp.saved][temp.saved] == 0) {
                dp[temp.num + temp.saved][temp.saved] = temp.time + 1;
                q.add(new Display(temp.num + temp.saved, temp.saved, temp.time + 1));
            }

            // delete one emoji from screen
            if (temp.num - 1 >= 0) {
                dp[temp.num - 1][temp.saved] = temp.time + 1;
                q.add(new Display(temp.num - 1, temp.saved, temp.time + 1));
            }
        }
        return -1;
    }

}
