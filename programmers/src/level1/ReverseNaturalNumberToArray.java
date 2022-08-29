class Solution {
    public int[] solution(long n) {

        String str = Long.toString(n);
        int[] arr = new int[str.length()];

        int cnt = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            arr[cnt++] = str.charAt(i) - '0';
        }

        return arr;
    }
}