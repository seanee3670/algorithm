package Greedy;

import java.io.*;

public class LostBracket {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();



        // 1. 문자를 숫자로. (00009 와 같은 숫자도 존재)
        // 2. 연산자 순서

        int N = countNumbers(str);
        int[] numArr = new int[N];
        char[] charArr = new char[N - 1];
        StringBuilder sb = new StringBuilder();

        int digits = 0; // 자릿수 기억을 위한 변수
        int opr = 0; // charArr[opr]을 위한 변수
        for (int i = 0; i < N; i++) {

            for (; digits < str.length(); digits++) {
                // 연산자를 만나지 않았다면
                char cur = str.charAt(digits);
                if (cur == '-' || cur == '+') {
                    charArr[opr++] = cur;
                    break;
                }
                sb.append(cur);
            }

            numArr[i] = Integer.valueOf(sb.toString()); // 문자를 숫자로 저장
            sb.setLength(0); // sb 초기화

            digits++; // 연산자 건너뛰기
        }

//        for (int e : numArr) {
//            System.out.println("e = " + e);
//        }
//
//        for (char c : charArr) {
//            System.out.println("c = " + c);
//        }

        /*
        case 1: + + -> 같음
        case 2: - + -> + 먼저 계산
        case 3: + - -> 같음
        case 4: - - -> 같음
        case ?: - - + +
        => + + 만 묶어주면 됨
        수 + 뺴기 그룹

        ex)5 - 4 - 2 + 1 + 9 - 1 ->
         */

        boolean minus = false;
        opr = 0;
        int sum = numArr[0];
        for (int i = 1; i < N; i++) {
            if (charArr[opr] == '-') {
                minus = true;
                sum -= numArr[i];
                opr++;
            } else if (minus) {
                sum -= numArr[i];
                opr++;
            } else if (!minus && charArr[opr] == '+') {
                sum += numArr[i];
                opr++;
            }
        }

        System.out.println(sum);
    }

    static int countNumbers(String str) {
        int N = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                N++;
            }
        }
        return N;
    }
}
