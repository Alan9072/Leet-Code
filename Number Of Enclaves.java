class Solution {
    public int numEnclaves(int[][] grid) {
        
        // for left boundary
        for(int i=0;i<grid.length;i++){
            if(grid[i][0] == 1){
                dfs(i,0,grid);
            }
        }
       
        // for right boundary
        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length - 1] == 1){
                dfs(i,grid[0].length - 1,grid);
            }
        }
        // for top boundary
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i] == 1){
                dfs(0,i,grid);
            }
        // for bottom boundary
        }for(int i=0;i<grid[0].length;i++){
            if(grid[grid.length - 1][i] == 1){
                dfs(grid.length - 1,i,grid);
            }
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1)count++;
            }
        }
        
        return count;
    }
    public void dfs(int index1,int index2,int[][] grid){
        if(index1 < 0 || index2 < 0 || index1 == grid.length || index2 == grid[0].length || grid[index1][index2] == 0){
            return;
        }
        grid[index1][index2] = 0;

        dfs(index1 + 1,index2,grid);
        dfs(index1 - 1,index2,grid);
        dfs(index1,index2 + 1,grid);
        dfs(index1,index2 - 1,grid);

    }
}
