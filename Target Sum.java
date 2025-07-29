class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }

        return dfs(nums,0,0,target,dp);
    }
    public int dfs(int[] nums,int idx,int sum,int target,int[][] dp){
        if(idx >= nums.length){
            if(sum == target)return 1;
            else{
                return 0;
            }
        }
        if(dp[idx][sum + 1000] != -1)return dp[idx][sum + 1000];

        //negative
        int neg = dfs(nums,idx+1,sum + -nums[idx],target,dp);
        //positive
        int pos = dfs(nums,idx+1,sum + nums[idx],target,dp);

        return dp[idx][sum + 1000] = neg + pos;
    }
}
