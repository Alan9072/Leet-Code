class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum = 0;
        for(int i = 0;i<accounts.length;i++){
            int totalmoney = 0;
            for(int j = 0;j<accounts[i].length;j++){
                totalmoney+=accounts[i][j];
            }
            if(totalmoney>sum){
                sum = totalmoney;
            }

        }
        return sum;
    }
}
