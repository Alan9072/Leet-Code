class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] arr : dp){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }
        return dfs(0,0,nums1,nums2,dp);
    }
    public int dfs(int idx1,int idx2,int[] nums1,int[] nums2,int[][] dp){
        if(idx1 == nums1.length || idx2 == nums2.length)return Integer.MIN_VALUE;
        if(dp[idx1][idx2] != Integer.MIN_VALUE)return dp[idx1][idx2];

        int take = nums1[idx1] * nums2[idx2];
        int nextStep = dfs(idx1+1,idx2+1,nums1,nums2,dp);
        if(nextStep > 0){
            take += nextStep;
        }

        int skip1 = dfs(idx1+1,idx2,nums1,nums2,dp);
        int skip2 = dfs(idx1,idx2+1,nums1,nums2,dp);

        return dp[idx1][idx2] =  Math.max(take,Math.max(skip1,skip2));
    }
}
