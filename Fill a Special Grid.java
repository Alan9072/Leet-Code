class Solution {
    int val = 0;

    public int[][] specialGrid(int N) {
        int size = (int) Math.pow(2, N);
        int[][] grid = new int[size][size];
        if(N == 0)return new int[][]{{0}};
        fill(grid, size - 1, 0, size);
        return grid;
    }

    public void fill(int[][] grid, int col, int row, int size) {
        if (size == 2) {
            grid[row][col] = val;
            val++;
            grid[row + 1][col] = val;
            val++;
            grid[row + 1][col - 1] = val;
            val++;
            grid[row][col - 1] = val;
            val++;
            return;
        }
        
        fill(grid, col, row, size / 2);
        fill(grid, col , row + size / 2, size / 2);
        fill(grid, col - size / 2, row + size/2, size / 2);
        fill(grid, col - size / 2, row , size / 2);
    }
}
