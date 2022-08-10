class AddNonExistingNumbers {
    public int solution(int[] numbers) {

        // 1 ~ 9 까지 더한 값
        int sum = 45;
        for (int num : numbers) {
            sum -= num;
        }

        return sum;
    }
}