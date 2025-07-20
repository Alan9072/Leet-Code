class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] != 0 && visited[i][j] == 0){
                    int sum = dfs(i,j,grid,visited);
                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int dfs(int i,int j, int[][] grid,int[][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == 1){
            return 0;
        }

        visited[i][j] = 1;
        int left = dfs(i,j -1,grid,visited);
        int right = dfs(i, j+ 1,grid,visited);
        int top = dfs( i- 1,j,grid,visited);
        int bottom = dfs( i +1,j,grid,visited);

        return grid[i][j] + left + right + top + bottom;
    }
}
