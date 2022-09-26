class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // String 배열 생성
        String[] answer = new String[n];

        // For loop :
        // 1) arr1과 arr2 element를 -> 이진수 String
        for (int i = 0; i < n; i++) {
            // n 자리까지 출력.. String.format("%0nd", 1111)
            int binaryFirstMap = Integer.parseInt(Integer.toBinaryString(arr1[i]));
            int binarySecondMap = Integer.parseInt(Integer.toBinaryString(arr2[i]));

            String RowOfFirstMap = String.format("%0" + n + "d", binaryFirstMap);
            String RowOfSecondMap = String.format("%0" + n + "d", binarySecondMap);

            StringBuffer sb = new StringBuffer();
            // 2) charAt(j)가 둘 다 0이면 공백. -> continue
            for (int j = 0; j < n; j++) {

                if (RowOfFirstMap.charAt(j) == '0' && RowOfSecondMap.charAt(j) == '0') {
                    sb.append(" ");
                    continue;
                }
                sb.append("#");
            }

            answer[i] = sb.toString();
        }

        return answer;


    }
}