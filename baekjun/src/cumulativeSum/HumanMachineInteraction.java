package cumulativeSum;

import java.io.*;
import java.util.StringTokenizer;

public class HumanMachineInteraction {

    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        int N = Integer.valueOf(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // repeat N times
        for (int i = 0; i < N; i++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            char letter = st.nextToken().charAt(0);

            int startPoint = Integer.valueOf(st.nextToken());
            int endPoint = Integer.valueOf(st.nextToken());

            sb.append(String.valueOf(countLetters(letter, startPoint, endPoint)) + "\n");

        }

        System.out.println(sb.toString());

    }

    static int countLetters(char letter, int startPoint, int endPoint) {
        int count = 0;

        for (int j = startPoint; j < endPoint + 1; j++) {
            if (str.charAt(j) == letter) {
                count++;
            }
        }
        return count;
    }
}
