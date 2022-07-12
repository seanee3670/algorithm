package cumulativeSum;

import java.util.*;
import java.io.*;

public class HumanMachineInteraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[][] sum = new int[str.length()][26];

        sum[0][str.charAt(0) - 'a']++;

        // save cumulative values to array 'sum'
        for (int i = 1; i < str.length(); i++) {
            int temp = str.charAt(i) - 'a';

            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j]; // previous value should be transferred to current element
            }
            sum[i][temp]++;
        }

        int N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char letter = st.nextToken().charAt(0);
            int startPoint = Integer.valueOf(st.nextToken());
            int endPoint = Integer.valueOf(st.nextToken());

            if (startPoint == 0) {
                sb.append(sum[endPoint][letter - 'a']).append('\n');
            }
            else if (startPoint != 0) {
                sb.append(sum[endPoint][letter - 'a'] - sum[startPoint - 1][letter - 'a']).append('\n');
            }
        }

        System.out.println(sb);
    }
}