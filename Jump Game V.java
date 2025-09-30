class Solution {
    public int maxJumps(int[] arr, int d) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);

        int max = 0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(dfs(i,dp,arr,d),max);
        }
        return max;
    }
    public int dfs(int idx,int[] dp,int[] arr,int d){
        if (dp[idx] != -1) return dp[idx];

        int rv = 1;
        int lv = 1;
        int rm = 0;
        int lm = 0;
        for(int i=1;i<=d;i++){

            if(rv == 1 && idx + i < arr.length){
                if(arr[idx + i] < arr[idx]){
                    rm = Math.max(rm,dfs(idx + i,dp,arr,d));
                }else{
                    rv = 0;
                }
            }
            if(lv == 1 && idx - i >= 0){
                if(arr[idx - i] < arr[idx]){
                    lm = Math.max(lm,dfs(idx - i,dp,arr,d));
                }else{
                    lv = 0;
                }
            }

        }

        return dp[idx] = 1 + Math.max(rm,lm);
    }
}
