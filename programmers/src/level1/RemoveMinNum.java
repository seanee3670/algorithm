class Solution {
    public int[] solution(int[] arr) {

        if (arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[arr.length - 1];

        // find index of min value
        int minIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }

        // remove arr's minIdx and copy to answer array
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == minIdx) {
                continue;
            }

            answer[count++] = arr[i];
        }

        // logic above can be substituted with 2 for loops (1. from 0 to minIdx 2. from minIdx to end)

        return answer;
    }
}