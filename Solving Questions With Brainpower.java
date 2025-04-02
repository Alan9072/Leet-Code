class Solution {

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp,-1);
        return points(0,questions,dp);
        
    }
    public long points(int index,int[][] questions,long[] dp){
        if(index >= questions.length){
            return 0 ;
        }
        if(dp[index] != -1)return dp[index];

        long take = questions[index][0] + points(index + questions[index][1] + 1, questions, dp);
        
        long skip = points(index + 1, questions, dp);

        return dp[index] = Math.max(take,skip);
    }
}
