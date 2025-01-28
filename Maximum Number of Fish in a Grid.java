class Solution {
    public int findMaxFish(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(find(i, j, grid), max);
                }
            }
        }
        return max;
    }

    public int find(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int sum = grid[i][j];
        grid[i][j] = 0;
        sum += find(i + 1, j, grid);
        sum += find(i - 1, j, grid);
        sum += find(i, j + 1, grid);
        sum += find(i, j - 1, grid);
        return sum;
    }
}
