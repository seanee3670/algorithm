import java.util.ArrayList;

public class PG_67257 { // 수식 최대화
    public static long answer = Long.MIN_VALUE;

    public static ArrayList<Long> numList = new ArrayList<>();
    public static ArrayList<String> oprList = new ArrayList<>();

    public static String[] opr = {"+", "-", "*"};
    public static String[] output = new String[3];
    public static boolean[] visited = new boolean[3];

    public long solution(String expression) {
        String n = "";
        for (int i = 0; i < expression.length(); i++) {
            char exp = expression.charAt(i);
            if (exp == '+' || exp == '-' || exp == '*') {
                oprList.add(exp + "");
                numList.add(Long.parseLong(n));
                n = "";
            } else {
                n += exp;
            }
        }

        numList.add(Long.parseLong(n));

        per(0, opr.length);

        return answer;
    }

    //순열 찾기
    static void per(int depth, int r) {
        if (depth == r) {
            solve(); // 연산

            return;
        }

        for (int i = 0; i < opr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = opr[i];
                per(depth + 1, r);
                visited[i] = false;
            }
        }
    }

    // 연산
    static void solve() {
        // 연산자 우선 순위에 따른 값을 얻기 위해 List 복사
        ArrayList<String> oper = new ArrayList<String>();
        oper.addAll(oprList);

        ArrayList<Long> num = new ArrayList<Long>();
        num.addAll(numList);

        for (int i = 0; i < output.length; i++) {
            String curOper = output[i]; // 현재 우선순위 연산자

            for (int j = 0; j < oper.size(); j++) {

                if (oper.get(j).equals(curOper)) { // 현재 우선순위에 맞는 연산자일 경우
                    long n1 = num.get(j);
                    long n2 = num.get(j + 1);
                    long res = cal(n1, n2, curOper);


                    num.remove(j + 1); // 숫자 삭제
                    num.remove(j);
                    oper.remove(j); // 연산자 삭제


                    num.add(j, res); // 연산 결과 넣기

                    j--; // 삭제했으니 인덱스 하나 줄여주기
                }
            }
        }

        answer = Math.max(answer, Math.abs(num.get(0)));
    }

    // 수식 계산
    static long cal(long n1, long n2, String o) {
        long res = 0;
        switch (o) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
        }

        return res;
    }
}
