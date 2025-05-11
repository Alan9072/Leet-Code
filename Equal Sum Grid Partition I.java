class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int preSum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                preSum += grid[i][j];
            }
        }

        //horizontal cut
        int hori = 0;
        int horiSum = preSum;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                hori += grid[i][j];
                horiSum -= grid[i][j];
            }
            if(hori == horiSum){
                return true;
            }
        }

        int verti = 0;
        int vertiSum = preSum;
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                verti += grid[j][i];
                vertiSum -= grid[j][i];
            }
            if(verti == vertiSum){
                return true;
            }
        }
        return false;
    }
}
