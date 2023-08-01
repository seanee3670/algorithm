import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RE_BOJ_3055 { // 탈출
    static int row;
    static int col;
    static char[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> flood = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        arr = new char[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = str.charAt(i);
                if (arr[i][j] == 'S') {
                    q.add(new int[]{j, i, 0});
                } else if (arr[i][j] == '*') {
                    flood.add(new int[]{j, i});
                }
            }
        }

        bfs();
        System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);



    }
    private static void bfs() {
        while (!q.isEmpty()) {
            // 홍수 업데이트
            int floodSize = flood.size();
            for (int i = 0; i < floodSize; i++) {
                int[] temp = flood.remove();
                for (int j = 0; j < dx.length; j++) {
                    int newX = temp[0] + dx[i];
                    int newY = temp[1] + dy[i];

                    if (newX < 0 || newX >= col || newY < 0 || newY >= row) {
                        continue;
                    }
                    arr[newY][newX] = '*';
                    flood.add(new int[]{newX, newY});
                }
            }

            // 도치의 모험 시작
            int qSize = q.size();
            for (int i = 0; i < q.size(); i++) {
                int[] temp = q.remove();
                for (int j = 0; j < dx.length; j++) {
                    int newX = temp[0] + dx[i];
                    int newY = temp[1] + dy[i];

                    if (newX < 0 || newX >= col || newY < 0 || newY >= row) {
                        continue;
                    }
                    if (arr[newY][newX] == 'D') { // 도착했다면
                        min = Math.min(min, temp[2] + 1);
                        return;
                    }
                    if (arr[newY][newX] == '.') { // 진행가능하다면
                        arr[newY][newX] = 'S';
                        q.add(new int[] {newX, newY, temp[2] + 1});
                    }
                }

            }
        }
    }
}
