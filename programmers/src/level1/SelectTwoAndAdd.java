import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                hashSet.add(numbers[i] + numbers[j]);
            }
        }

        Integer[] answerArray = hashSet.toArray(new Integer[0]);
        Arrays.sort(answerArray);
        int[] answerArrayAsInt = Arrays.stream(answerArray).mapToInt(i->i).toArray();

        return answerArrayAsInt;
    }
}