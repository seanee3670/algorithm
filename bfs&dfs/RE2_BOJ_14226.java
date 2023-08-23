import java.util.*;
import java.io.*;

public class RE2_BOJ_14226 { // 이모티콘
    static class Memory {
        int display;
        int clipboard;
        int time;

        public Memory(int display, int clipboard, int time) {
            this.display = display;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
    static final int LIMIT = 1000 * 2 + 1;
    static boolean[][] visited = new boolean[LIMIT][LIMIT];
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        System.out.println(bfs());

    }
    static int bfs() {
        Queue<Memory> q = new LinkedList<>();
        q.add(new Memory(1, 0, 0));
        while (!q.isEmpty()) {
            Memory temp = q.remove();
            if (temp.display == N) {
                return temp.time;
            }

            // todo: clipboard = display
            if (!visited[temp.display][temp.display]) {
                visited[temp.display][temp.display] = true;
                q.add(new Memory(temp.display, temp.display, temp.time + 1));
            }

            // todo: display += clipboard
            if (temp.clipboard != 0 && temp.display + temp.clipboard < LIMIT && !visited[temp.display + temp.clipboard][temp.clipboard]) {
                visited[temp.display + temp.clipboard][temp.clipboard] = true;
                q.add(new Memory(temp.display + temp.clipboard, temp.clipboard, temp.time + 1));
            }

            // todo: display - 1;
            if (temp.display - 1 >= 0 && !visited[temp.display - 1][temp.clipboard]) {
                visited[temp.display - 1][temp.clipboard] = true;
                q.add(new Memory(temp.display - 1, temp.clipboard, temp.time + 1));
            }


        }

        return -1;

    }

}
