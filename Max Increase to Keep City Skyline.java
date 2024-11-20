class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int row[] = new int[grid.length];
        int col[] = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            int maxRow = 0;
            int maxCol = 0;
            for (int j = 0; j < grid[i].length; j++) {
                maxRow = Math.max(maxRow, grid[i][j]);
            }
            row[i] = maxRow;
            for (int j = 0; j < grid[i].length; j++) {
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            col[i] = maxCol;
        }
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                sum += Math.min(row[i],col[j]) - grid[i][j];
            }
        }
        return sum;
    }
}
