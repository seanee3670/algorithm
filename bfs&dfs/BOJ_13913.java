import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13913 {
    static int N, K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.valueOf(split[0]);
        K = Integer.valueOf(split[1]);

        bfs();

        // 순서대로 구하기 위해 stack 에 담은 후 pop
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int idx = K;

        while (idx != N) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }
        int cnt = stack.size() - 1;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = now + 1;
                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (time[next] == 0) {
                    q.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }


}
