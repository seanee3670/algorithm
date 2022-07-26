package que;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class QueTwo {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.valueOf(br.readLine());

        StringTokenizer cmd;

        while(N-- > 0) {
            cmd = new StringTokenizer(br.readLine(), " ");

            switch (cmd.nextToken()) {
                case "push":
                    q.offer(Integer.valueOf(cmd.nextToken()));
                    break;

                case "pop":
                    Integer item = q.poll();
                    if (item == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(item).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    Integer ite = q.peek();
                    if (ite == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(ite).append('\n');
                    }
                    break;

                case "back":
                    Integer it = q.peekLast();
                    if (it == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(it).append('\n');
                    }
                    break;
            }
        };
        System.out.println(sb);
    }
}
