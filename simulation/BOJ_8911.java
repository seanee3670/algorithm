import java.io.*;

public class BOJ_8911 { // 거북이

    // 0 -> N (0 1)
    // 1 -> E (1, 0)
    // 2 -> S (0, -1)
    // 3 -> W (-1, 0)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    static class Turtle {
        int x;
        int y;
        int direction;

        public Turtle(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
        void move(char order) {
            if (order == 'F') {
                this.x += dx[this.direction];
                this.y += dy[this.direction];
            } else if (order == 'B') {
                this.x -= dx[this.direction];
                this.y -= dy[this.direction];
            }
        }

        void turnRight() {
            this.direction = (this.direction + dx.length + 1) % dx.length;
        }

        void turnLeft() {
            this.direction = (this.direction + dx.length - 1) % dx.length;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Turtle turtle = new Turtle(0, 0, 0);
            int xMin = 0;
            int xMax = 0;
            int yMin = 0;
            int yMax = 0;

            char[] orders = br.readLine().toCharArray();

            for (char order : orders) {
                if (order == 'R') {
                    turtle.turnRight();
                } else if (order == 'L') {
                    turtle.turnLeft();
                } else {
                    turtle.move(order);

                    xMin = Math.min(xMin, turtle.x);
                    xMax = Math.max(xMax, turtle.x);
                    yMin = Math.min(yMin, turtle.y);
                    yMax = Math.max(yMax, turtle.y);
                }
            }

            int area = (xMax - xMin) * (yMax - yMin);
            sb.append(String.valueOf(area) + '\n');
        }

        System.out.println(sb.toString());

    }


}
