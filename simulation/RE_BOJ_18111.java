import java.io.*;
import java.util.StringTokenizer;

public class RE_BOJ_18111 { // 마인크래프트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.valueOf(st.nextToken());
        int col = Integer.valueOf(st.nextToken());
        int inv = Integer.valueOf(st.nextToken());

        int max = 0;
        int min = 500;
        int[][] board = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
                max = Math.max(max, board[i][j]);
                min = Math.min(min, board[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int highest = -1;
        // max ~ min
        for (int mid = max; mid >= min; mid--) {
            int tempTime = 0;
            int tempInv = inv;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] < mid) { // 채우기
                        tempInv -= (mid - board[i][j]);
                        tempTime += mid - board[i][j];
                    } else if (board[i][j] > mid) { // 깎기
                        tempTime += ((board[i][j] - mid) * 2);
                        tempInv += (board[i][j] - mid);
                    }
                }
            }
            if (tempInv < 0) {
                continue;
            }
            if (minTime > tempTime) {
                minTime = tempTime;
                highest = mid;
            }
        }

        System.out.println(minTime + " " + highest);

    }
}
