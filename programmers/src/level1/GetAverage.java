import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        double average = Arrays.stream(arr).average().orElse(0);

        return average;
    }
}