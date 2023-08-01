import java.util.*;
public class PG_67256 { // [카카오 인턴] 키패드 누르기
    static StringBuilder record = new StringBuilder();
    static int L = 10;
    static int R = 12;

    static void addToRecord(String hand, int num) {
        if (hand.equals("left")) {
            record.append(num);
            L = num;
            return;
        } else if (hand.equals("right")){
            record.append(num);
            R = num;
            return;
        }
        throw new IllegalArgumentException("inappropriate argument(s)!");
    }
    private String solution(int[] numbers, String hand) {
        for (int num : numbers) {
            if (num == 1 | num == 4 | num == 7) { // 왼손
                addToRecord("left", num);
            } else if (num == 3 | num == 6 | num == 9) {
                addToRecord("right", num);
            } else {
                if (num == 0) {
                    num = 11;
                }
                int lDiff = getDiff(L, num);
                int rDiff = getDiff(R, num);

                if (lDiff < rDiff) {
                    addToRecord("left", num);
                } else if (rDiff < lDiff) {
                    addToRecord("right", num);
                } else {
                    addToRecord(hand, num);
                }
            }
        }
        return record.toString();
    }

    static int getDiff(int num1, int num2) {
        num1--;
        num2--;
        int xDiff = Math.abs(((num1) % 3 ) - ((num2) % 3));
        int yDiff = Math.abs((num1 / 3) - (num2 / 3));
        return xDiff + yDiff;
    }

}
