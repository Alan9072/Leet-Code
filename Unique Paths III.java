class Solution {
    int total = 0;

    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    path(grid, count, 0, i, j);
                }
            }
        }
        return total;
    }

    public void path(int[][] grid,int count,int addUp,int i,int j){
           if(i == grid.length || i < 0 || j == grid[0].length || j < 0 || grid[i][j] == 3|| grid[i][j] == -1)return;
           if(grid[i][j] == 2){
                if((addUp - 1) == count){
                    total++;
                    return;
                }else{
                    return;
                }
           }

           grid[i][j] = 3;
           addUp++;
           
           path(grid,count,addUp,i+1,j);
           path(grid,count,addUp,i-1,j);
           path(grid,count,addUp,i,j+1);
           path(grid,count,addUp,i,j-1);
           
           addUp--;
           grid[i][j] = 0;
    }
}
