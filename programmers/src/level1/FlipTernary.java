class Solution {
    public int solution(int n) {
        // n -> 3진법 String
        String ternary = Integer.toString(n, 3);

        // StringBuffer 에 3진법으로 변환된 변수 담기
        StringBuffer sb = new StringBuffer(ternary);

        // 뒤집어서 flippedTernary 변수에 저장
        String flippedTernary = sb.reverse().toString();

        // 10진법으로 변환해서 int로 반환
        return Integer.parseInt(flippedTernary, 3);
    }
}