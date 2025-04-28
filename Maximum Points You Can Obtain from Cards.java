class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int length = cardPoints.length;
        int start = length - k;
        int end = start;
        int score = 0;

        while(end < length){
            score += cardPoints[end];
            end++;
        }

        end = 0;
        maxScore = Math.max(score,maxScore);

        if(k == length)return maxScore;

        do{
            score += cardPoints[end];
            score -= cardPoints[start];
            maxScore = Math.max(score,maxScore);
            start = (start + 1) % length;
            end = (end + 1) % length;
        }while(end != k);
        
        return maxScore;
    }
}
