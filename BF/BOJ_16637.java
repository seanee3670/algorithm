import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_16637 { // 괄호 추가하기 G4
    static int N;
    static int max = Integer.MIN_VALUE;
    static List<Integer> numList = new ArrayList<>();
    static List<Character> oprList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        String str = br.readLine();


        // add number OR operator to the corresponding list
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                numList.add(str.charAt(i) - '0');
            } else {
                oprList.add(str.charAt(i));
            }
        }

        int start = numList.get(0);
        dfs(0, start);
        System.out.println(max);

    }
    static void dfs(int depth, int sum) {
        if (depth >= oprList.size()) {
            max = Math.max(max, sum);
            return;
        }
        // proceed w/out brackets
        int temp = calculate(depth, sum, numList.get(depth + 1));
        dfs(depth + 1, temp);

        // proceed w/ brackets
        if (depth + 1 < oprList.size()) {
            temp = calculate(depth + 1, numList.get(depth + 1), numList.get(depth + 1));
            dfs(depth + 2, calculate(depth, sum, temp));
        }

    }

    private static int calculate(int oprIdx, int a, int b) {
        char ch = oprList.get(oprIdx);
        if (ch == '+') {
            return a + b;
        }

        else if (ch == '-') {
            return a - b;
        }
        // ch == '*'
        return a * b;
    }
}
