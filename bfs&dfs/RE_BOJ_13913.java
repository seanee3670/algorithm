import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RE_BOJ_13913 {
    static final int LIMIT = 100000;
    static final int CASES = 3;
    static int[] time;
    static int[] prev;
    static int start;
    static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        start = Integer.valueOf(info[0]);
        target = Integer.valueOf(info[1]);

        time = new int[LIMIT + 1];
        time[start] = 0;
        prev = new int[LIMIT + 1];

        bfs();

        // 시간 출력
        System.out.println(time[target]);

        Stack<Integer> stack = new Stack<>();
        int now = target;
        for (int i = 0; i <= time[target]; i++) {
            stack.add(now);
            now = prev[now];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        // StringBuilder 쓰면 더욱 효율적


    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            // target 에 도달했다면 return
            if (now == target) {
                return;
            }

            // 3 가지 경우의 수 존재
            for (int i = 0; i < CASES; i++) {
                int next;
                if (i == 0) {
                    next = now + 1;
                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }
                // 유효성 검사
                if (next < 0 || next > LIMIT) {
                    continue;
                }

                // next 가 첫방문이라면
                if (time[next] == 0) {
                    time[next] = time[now] + 1;
                    prev[next] = now;
                    q.add(next);
                }
            }
        }
    }
}
