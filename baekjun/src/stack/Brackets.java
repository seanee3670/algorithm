package stack;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Arrays;

public class Brackets {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '(') {
                    stack.push(')');

                } else if (ch == ')') {
                    if (stack.pop() != ch) {
                        sb.append("NO" + '\n');
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES" + '\n');
            }

            stack.clear();
        }

        System.out.println(sb.toString());
    }
}
