class Solution {

    final int YEAR_START_DAY = 5; // 0 == SUN
    public String solution(int a, int b) {

        // month array로 1월 1일로부터 얼마나 경과했는지 계산
        // 1월은 아직 달이 넘어가지 않았기에, 1을 빼는 대신 배열 순서를 하나 뒤로 미룸
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 새해 첫째날은 0번째여야 하므로 1을 빼주는 대신 배열 순서를 하나 뒤로 미룸
        String[] days = {"SAT", "SUN", "MON", "TUE" , "WED", "THU", "FRI"};

        int daysPassed = 0;

        if (a > 1) {
            for (int i = 1; i < a; i++) {
                daysPassed += months[i];
            }
        }

        return days[(daysPassed + YEAR_START_DAY + b) % 7];
    }
}