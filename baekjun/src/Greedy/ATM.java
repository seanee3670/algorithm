package Greedy;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
        }

        System.out.println(sum);
    }
}
