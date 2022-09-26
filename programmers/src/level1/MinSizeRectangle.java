class Solution {
    public int solution(int[][] sizes) {

        int maxLongerSide = 0;
        int maxShorterSide = 0;

        for (int i = 0; i < sizes.length; i++) {
            int longerSide = Math.max(sizes[i][0], sizes[i][1]);
            int shorterSide = Math.min(sizes[i][0], sizes[i][1]);

            maxLongerSide = Math.max(maxLongerSide, longerSide);
            maxShorterSide = Math.max(maxShorterSide, shorterSide);
        }

        return maxLongerSide * maxShorterSide;


    }
}
