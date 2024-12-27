class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max_i = values[0] + 0;
        int maxScore = Integer.MIN_VALUE;
        for(int j=1;j<values.length;j++){
            int score = max_i + values[j] - j;
            if(score > maxScore) maxScore = score;
            max_i = Math.max(max_i,values[j] + j);
        }
    return maxScore;
    }
}
