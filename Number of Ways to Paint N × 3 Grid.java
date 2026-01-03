class Solution {
    int MOD = 1000000000 + 7;
    public int numOfWays(int n) {
        int[][][][] dp = new int[n][3][3][3];
        for(int[][][] arr : dp){
            for(int[][] sub : arr){
                for(int[] supSub : sub){
                    Arrays.fill(supSub,-1);
                }
            }
        }
        return dfs(0, 0, 0, 0, n,dp);
    }

    public int dfs(int idx, int prevA, int prevB, int prevC, int n,int[][][][] dp) {
        if (idx >= n)
            return 1;
        if(dp[idx][prevA][prevB][prevC] != -1)return  dp[idx][prevA][prevB][prevC];

        int col[] = new int[] { 0, 1, 2 };
        int sum = 0;
        if (prevA == 0 && prevB == 0 && prevC == 0) {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (col[i] == col[j])
                        continue;
                    for (int k = 0; k < 3; k++) {
                        if (col[j] == col[k])
                            continue;
                        sum = (sum +  dfs(idx + 1, col[i], col[j], col[k], n,dp)) % MOD;
                    }
                }
            }
            return sum;
        } else {

            for (int i = 0; i < 3; i++) {
                if (col[i] == prevA)
                    continue;
                for (int j = 0; j < 3; j++) {
                    if (col[i] == col[j])
                        continue;
                    if (col[j] == prevB)
                        continue;
                    for (int k = 0; k < 3; k++) {
                        if (col[j] == col[k])
                            continue;
                        if (col[k] == prevC)
                            continue;
                        sum = (sum +  dfs(idx + 1, col[i], col[j], col[k], n,dp)) % MOD;
                    }
                }
            }
            return dp[idx][prevA][prevB][prevC] = sum;
        }

    }
}
