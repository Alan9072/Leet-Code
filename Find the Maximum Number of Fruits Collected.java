class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int[][] dp = new int[fruits.length][fruits.length];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int n = fruits.length;
        int diag = 0;
        for(int i=0;i<n;i++){
            diag += fruits[i][i];
        }
        int r = dfs(0,n-1,fruits,0,dp);//top-right
        int l = dfs(n-1,0,fruits,1,dp);//bottom-left

        return l + r + diag;

    }
    public int dfs(int i,int j,int[][] fruits,int side,int[][] dp){

        if(i == j)return 0;
        if((side == 0 && j < i) || (side == 1 && i < j))return 0;
        if(i >= fruits.length || j >= fruits.length)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(side == 0){
            int bl = dfs(i+1,j-1,fruits,0,dp);

            int bt = dfs(i+1,j,fruits,0,dp);

            int br = dfs(i+1,j+1,fruits,0,dp);

            return dp[i][j] = fruits[i][j] + Math.max(bl,Math.max(bt,br));
            
        }else{
            int tr = dfs(i-1,j+1,fruits,1,dp);

            int ri = dfs(i,j+1,fruits,1,dp);

            int rb = dfs(i+1,j+1,fruits,1,dp);

            return dp[i][j] = fruits[i][j] + Math.max(tr,Math.max(ri,rb));
            
        }

    }
}
