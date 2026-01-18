class Solution {
    public int largestMagicSquare(int[][] grid) {
        int result = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
 
                int vSteps = grid.length - i;
                int hSteps = grid[0].length - j;
                int minSteps = Math.min(vSteps, hSteps);

                for(int k=0;k<minSteps;k++){
                    if(find(i,j,grid,k)){
                        result = Math.max(result,1 + k);
                    }
                }
            }
        }
        return result;
    }
    public boolean find(int id1,int id2,int[][] grid,int limit){
        int hSum = 0;
        int vSum = 0;
        for(int i=id1;i<=id1+limit;i++){
            int subH = 0;
            for(int j=id2;j<=id2+limit;j++){
                subH += grid[i][j];
            }
            if(hSum == 0){
                hSum = subH;
            }else if(subH != hSum){
                return false;
            }

        }
        for(int i=id2;i<=id2+limit;i++){
            int subV = 0;
            for(int j=id1;j<=id1+limit;j++){
                subV += grid[j][i];
            }

            if(vSum == 0){
                vSum = subV;
            }else if(subV != vSum){
                return false;
            }
        }
        
        if(vSum != hSum)return false;
        //diagonal check
        int diagSum = 0;
        int cnt = 0;
        for(int i=id1;i<=id1+limit;i++){
            diagSum += grid[i][id2 + cnt];
            cnt++;
        }
        if(hSum != diagSum)return false;
        // next diag
        diagSum = 0;
        cnt = 0;
        for(int i=id1+limit;i>=id1;i--){
            diagSum += grid[i][id2 + cnt];
            cnt++;
        }
        if(hSum != diagSum)return false;

        return true;
    }

    
}
