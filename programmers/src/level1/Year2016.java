class Solution {

    final int yearStartDay = 5; // 0 == SUN
    public String solution(int a, int b) {

        // month array로 1월 1일로부터 얼마나 경과했는지 계산
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"SUN", "MON", "TUE" , "WED", "THU", "FRI", "SAT"};

        int daysPassed = 0;

        if (a > 1) {
            for (int i = 1; i < a; i++) {
                daysPassed += months[i];
            }
        }

        return days[(daysPassed + yearStartDay + b) % 7];
    }
}