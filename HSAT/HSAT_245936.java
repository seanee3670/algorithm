import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HSAT_245936 { // [HSAT 3회 정기 코딩 인증평가 기출] 플레이페어 암호
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String key = br.readLine();
        board = new char[5][5];
        List<Character> abc = new ArrayList<>();

        // fill abc list
        for (int i = 0; i < 26; i++) {
            if ((char) 'A' + i == 'J') {
                continue;
            }
            abc.add((char) ('A' + i));
        }

        int r = 0;
        int c = 0;

        // fill board with key
        for (int i = 0; i < key.length(); i++) {
            if (abc.contains(key.charAt(i))) {
                board[r][c] = key.charAt(i);
                abc.remove(Character.valueOf(board[r][c]));
                c++;
                if (c == board[0].length) {
                    c = 0;
                    r++;
                }
            }
        }

        // fill board with remaining abcs
        for (int i = 0; i < abc.size(); i++) {
            board[r][c] = abc.get(i);
            c++;
            if (c == board[0].length) {
                c = 0;
                r++;
            }
        }

        System.out.println(convertMessage(message));


    }

    static String convertMessage(String message) {
        StringBuilder sb = new StringBuilder(message);

        // Slice message by 2 chars
        int idx = 0;
        while (idx < sb.length() - 1) {
            if (sb.charAt(idx) == sb.charAt(idx + 1)) {
                // XXX
                if (sb.charAt(idx) == 'X') {
                    sb.insert(idx + 1, 'Q');
                } else {
                    sb.insert(idx + 1, 'X');
                }
                idx += 2;
            }
        }

        // if sb is odd number, add 'X'
        if (sb.length() % 2 == 1) {
            sb.append('X');
        }

        idx = 0;
        while (idx < sb.length() - 1) {
            char c1 = sb.charAt(idx);
            char c2 = sb.charAt(idx + 1);
            int x1 = 0;
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == c1) {
                        x1 = i;
                        y1 = j;
                    }
                    if (board[i][j] == c2) {
                        x2 = i;
                        y2 = j;
                    }
                }
            }

            // if same row
            if (y1 == y2) {
                if (x1 + 1 >= board.length) {
                    x1 = -1;
                }
                if (x2 + 1 >= board.length) {
                    x2 = -1;
                }
                sb.setCharAt(idx, board[y1][x1 + 1]);
                sb.setCharAt(idx + 1, board[y2][x2 + 1]);
            }

            // if same col
            if (x1 == x2) {
                if (y1 + 1 >= board.length) {
                    y1 = -1;
                }
                if (y2 + 1 >= board.length) {
                    y2 = -1;
                }
                sb.setCharAt(idx, board[y1 + 1][x1]);
                sb.setCharAt(idx + 1, board[y2 + 1][x2]);
                idx += 2;
                continue;
            }

            // if different row and col, switch x
            sb.setCharAt(idx, board[y1][x2]);
            sb.setCharAt(idx, board[y2][x1]);
            idx += 2;

        } // while loop end
        return sb.toString();

    }
}
