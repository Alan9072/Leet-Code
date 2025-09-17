class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sum = 0;
        
        int minRow = Math.min(startPos[0],homePos[0]);
        int maxRow = Math.max(startPos[0],homePos[0]);

        int minCol = Math.min(startPos[1],homePos[1]);
        int maxCol = Math.max(startPos[1],homePos[1]);

        for(int i=minRow+1;i<=maxRow;i++){
            sum += rowCosts[i];
        }
        if(homePos[0] < startPos[0]){
            sum += rowCosts[homePos[0]];
            sum -= rowCosts[startPos[0]];
        }

        for(int i=minCol+1;i<=maxCol;i++){
            sum += colCosts[i];
        }
        if(homePos[1] < startPos[1]){
            sum += colCosts[homePos[1]];
            sum -= colCosts[startPos[1]];
        }
        
        return sum;
    }
}
