import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 { // 이모티콘
    static class Display {
        int num;
        int saved;
        int time;

        Display(int num, int saved, int time) {
            this.num = num;
            this.saved = saved;
            this.time = time;
        }

    }

    static boolean[][] visited;
    static final int LIMIT = 2000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        visited = new boolean[LIMIT + 1][LIMIT + 1];

        bfs();


//        Arrays.fill(arr, Integer.MAX_VALUE);

        // 클립보드 저장 -> 변수에 저장
        // 클립보드 붙여넣기 -> 변수 만큼 더하기
        // 화면 이모티콘 하나 삭제 -> -1

    }

    static void bfs() {
        Queue<Display> q = new LinkedList<>();
        q.add(new Display(1, 0, 0));

        while (!q.isEmpty()) {
            Display temp = q.remove();
            if (temp.num == N) {
                System.out.println(temp.time);
                return;
            }

            if (temp.num > 0 && temp.num < LIMIT) {
                // copy to clipboard(saved)
                if (!visited[temp.num][temp.num]) {
                    visited[temp.num][temp.num] = true;
                    q.add(new Display(temp.num, temp.num, temp.time + 1));
                }

                // delete one
                if (!visited[temp.num - 1][temp.saved]) {
                    visited[temp.num - 1][temp.saved] = true;
                    q.add(new Display(temp.num - 1, temp.saved, temp.time + 1));
                }
            }

            // paste from clipboard(saved)
            if (temp.num > 0 && temp.num + temp.saved < LIMIT) {
                if (!visited[temp.num + temp.saved][temp.saved]) {
                    visited[temp.num + temp.saved][temp.saved] = true;
                    q.add(new Display(temp.num + temp.saved, temp.saved, temp.time + 1));
                }
            }
        }
    }
}
