package Greedy;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Treasure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arrA = new int[N];
        int[] arrB = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arrA[i] * arrB[(N - 1) - i];
        }

        System.out.println(sum);

    }
}
