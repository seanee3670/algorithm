import java.util.Arrays;

class KthNumber {
    public int[] solution(int[] array, int[][] commands) {

        int commandsLength = commands.length;

        int[] answer = new int[commandsLength];

        for (int i = 0; i < commands.length; i++) {
            int beg = commands[i][0] - 1; // 배열은 0부터 시작한다
            int end = commands[i][1];
            int target = commands[i][2] - 1;

            int[] subArray = Arrays.copyOfRange(array, beg, end);
            Arrays.sort(subArray);

            answer[i] = subArray[target];
        }

        return answer;
    }
}