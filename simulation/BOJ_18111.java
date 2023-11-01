import java.io.*;
import java.util.*;

public class BOJ_18111 { // 마인크래프트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());


        int min = 256;
        int max = 0;
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }
        int answer = Integer.MAX_VALUE;
        int height = 0;
        //dig upper, pour over lower
        for (int median = min; median <= max; median++) {
            int time = 0;
            int inv = B;
            for (int[] arr : board) {
                for (var num : arr) {
                    if (num > median) { // 깎기
                        time += ((num - median) * 2);
                        inv += (num - median);
                    } else if (num < median) { // 채우기
                        time += (median - num);
                        inv -= (median - num);
                    }
                }
            }

            if (inv < 0) { // check at the end, since the process can take place in any order
                break;
            }

            if (time <= answer) {
                answer = time;
                height = median;
            }

        }

        System.out.println(answer + " " + height);

    }

}
