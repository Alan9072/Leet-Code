class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int dup[][] = new int[grid.length][grid[0].length];
        int onesrow[] = new int[grid.length];
        int onescol[] = new int[grid[0].length];
        int pos = 0;
        int y = 0;
        //////////////////////////////////////////////////
        for(int k=0;k<grid[0].length;k++){
                int ones = 0;
                for(int j=0;j<grid.length;j++){
                     int val = grid[j][pos];
                     if(val == 1)ones++;
                }
                 onescol[y] = ones;
                 y++;
                 pos++;
            }
        /////////////////////////////////////////////
        for(int i=0;i<grid.length;i++){
            
            int curr[] = grid[i];
            int ones = 0;
            for(int k=0;k<curr.length;k++){
                if(curr[k] == 1)ones++;
            }
            onesrow[i] = ones;
        }
        /////////////////////////////////////////////
        int total = grid.length + grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                dup[i][j] = onesrow[i] + onescol[j] - (total  - onesrow[i] - onescol[j] ) ;
            }
        }
    return dup;
    }
}
