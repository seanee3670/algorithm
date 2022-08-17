import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        for (String runner : participant) {
            boolean hasFinished = false;

            // for (String winner : completion) {
            //     if (runner.equals(winner)) {
            //         hasFinished = true;
            //         winner = null;
            //         break;
            //     }
            // }

            for (int i = 0; i < completion.length; i++) {
                if (runner.equals(completion[i])) {
                    hasFinished = true;
                    completion[i] = null;
                    break;
                }
            }

            if (hasFinished == false) {
                return runner;
            }
        }
        return answer;
    }
}