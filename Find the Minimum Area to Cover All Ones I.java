class Solution {
    public int minimumArea(int[][] grid) {
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;

        //top
        boolean condition = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    top = i;
                    condition = true;
                    break;
                }
            }
            if(condition)break;
        }
        //bottom
        condition = false;
        for(int i=grid.length - 1;i>=0;i--){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    bottom = i;
                    condition = true;
                    break;
                }
            }
            if(condition)break;
        }
        //left
        condition = false;
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i] == 1){
                    left = i;
                    condition = true;
                    break;
                }
            }
            if(condition)break;
        }
        //right
        condition = false;
        for(int i=grid[0].length - 1;i>=0;i--){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i] == 1){
                    right = i;
                    condition = true;
                    break;
                }
            }
            if(condition)break;
        }

        return (bottom - top + 1) * (right - left + 1);
    }
}
