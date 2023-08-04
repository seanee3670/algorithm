import java.util.ArrayDeque;
import java.util.Deque;

public class PG_42883 { // 큰 수 만들기
    public String solution(String number, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            // dq가 비어있다면 추가
            if (dq.isEmpty()) {
                dq.addFirst(ch);
            } else {
                // peek 값과 비교
                if (dq.peek() < ch) {
                    dq.removeFirst();
                    dq.addFirst(ch);
                }
            }

            if (dq.size() == k) {
                break;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : dq) {
            System.out.println(ch);
            sb.append(String.valueOf(ch));

        }

        return sb.toString();

    }

}
//class Solution {
//    public int[] solution(int[] sequence, int k) {
//
//        int N = sequence.length;
//        int left = 0, right = N;
//        int sum = 0;
//        for(int L = 0, R = 0; L < N; L++) {
//            while(R < N && sum < k) {
//                sum += sequence[R++];
//            }
//
//            if(sum == k) {
//                int range = R - L - 1;
//                if((right - left) > range) {
//                    left = L;
//                    right = R - 1;
//                }
//            }
//
//            sum -= sequence[L];
//        }
//
//        int[] answer = {left, right};
//
//        return answer;
//    }
//}import java.util.ArrayDeque;
//import java.util.Deque;
//
//public class PG_42883g { //
//    public String solution(String number, int k) {
//        Deque<Character> dq = new ArrayDeque<>();
//        for (int i = 0; i < number.length(); i++) {
//            char ch = number.charAt(i);
//            // dq가 비어있다면 추가
//            if (dq.isEmpty()) {
//                dq.addFirst(ch);
//            } else {
//                // peek 값과 비교
//                if (dq.peek() < ch) {
//                    dq.removeFirst();
//                    dq.addFirst(ch);
//                }
//            }
//
//            if (dq.size() == k) {
//                break;
//            }
//
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (Character ch : dq) {
//            System.out.println(ch);
//            sb.append(String.valueOf(ch));
//
//        }
//
//        return sb.toString();
//
//    }
//
//}
////class Solution {
////    public int[] solution(int[] sequence, int k) {
////
////        int N = sequence.length;
////        int left = 0, right = N;
////        int sum = 0;
////        for(int L = 0, R = 0; L < N; L++) {
////            while(R < N && sum < k) {
////                sum += sequence[R++];
////            }
////
////            if(sum == k) {
////                int range = R - L - 1;
////                if((right - left) > range) {
////                    left = L;
////                    right = R - 1;
////                }
////            }
////
////            sum -= sequence[L];
////        }
////
////        int[] answer = {left, right};
////
////        return answer;
////    }
////}