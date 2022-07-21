package stack;

import java.io.*;

public class Zero {

    static int[] stack;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        stack = new int[N];

        while (N-- > 0) {
            int num = Integer.valueOf(br.readLine());

            if (num == 0) {
               pop();
            } else if (num != 0) {
                push(num);
            }
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += stack[i];
        }

        System.out.println(sum);

    }

    static void push(int item) {
        stack[size] = item;
        size++;
    }

    static int pop() {
        if (size == 0) {
            return -1;
        }

        int res = stack[size - 1];
        stack[size - 1] = 0;
        size--;
        return res;
    }


}
