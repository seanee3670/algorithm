import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 { // 탈출
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;
    static boolean[][] visited;
    static int col;
    static int row;
    static String answer = "";

    static class Sqr {
        int x;
        int y;
        int time;

        Sqr(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static Sqr start;
    static Sqr goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        visited = new boolean[col][row];
        arr = new char[col][row];
        for (int i = 0; i < col; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < row; j++) {
                arr[i][j] = chArr[j];
                if (arr[i][j] == 'S') {
                    start = new Sqr(j, i, 0);
                }
                if (arr[i][j] == 'D') {
                    goal = new Sqr(j, i, 0);
                }
            }
        }

        implementEstimatedFlood();
        System.out.println(answer);


    }

    static void bfs() {
        Queue<Sqr> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            Sqr temp = q.remove();

            if (temp.time > cnt) {
                implementFlood();
                cnt++;
            }

            for (int i = 0; i < dx.length; i++) {
                int newX = temp.x + dx[i];
                int newY = temp.y + dy[i];

                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }

                if (visited[newY][newX] || !isSafe(arr[newY][newX])) {
                    continue;
                }
                if (arr[newY][newX] == 'D') {
                    answer = String.valueOf(temp.time);
                    return;
                }
                q.add(new Sqr(newX, newY, temp.time + 1));
            }
        }
        answer = "KAKTUS";
    }

    static boolean isSafe(char ch) {
        if (ch == 'X' || ch == '*' || ch == '#') {
            return false;
        }
        return true;
    }

    static void implementEstimatedFlood() { // * 주위를 # 변경
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (arr[i][j] == '*') {
                    for (int k = 0; k < dx.length; k++) {
                        int newX = j + dx[k];
                        int newY = i + dy[k];
                        if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                            continue;
                        }
                        if (arr[newY][newX] == 'D' || arr[newY][newX] == 'X' || arr[newY][newX] == '*') {
                            continue;
                        }
                        arr[newY][newX] = '#';
                    }
                }
            }
        }
    }

    static void implementFlood() { // # -> *
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (arr[i][j] == '#') {
                    arr[i][j] = '*';
                }
            }
        }
    }
}
