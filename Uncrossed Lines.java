class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(0,0,dp,nums1,nums2);
    }
    public int dfs(int i1,int i2,int[][] dp,int[] nums1,int[] nums2){
        if(i1 == nums1.length || i2 == nums2.length)return 0;

        if(dp[i1][i2] != -1)return dp[i1][i2];

        if(nums1[i1] == nums2[i2]){
            return dp[i1][i2] = 1 + dfs(i1 + 1,i2 + 1,dp,nums1,nums2);
        }else{
            int topM = dfs(i1 + 1,i2,dp,nums1,nums2);
            int bottomM = dfs(i1,i2 + 1,dp,nums1,nums2);
            return dp[i1][i2] = Math.max(topM,bottomM);
        }
    }
}
