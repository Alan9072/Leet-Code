class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int[][][][] dp = new int[grid.length][grid[0].length][5][3];
        for (int[][][] arr : dp) {
            for (int[][] arr1 : arr) {
                for (int[] arr2 : arr1) {
                    Arrays.fill(arr2, -1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, 0, 0, 0, grid, dp));
                }
            }
        }
        return max;
    }

    public int dfs(int i, int j, int dir, int prev, int toggle, int[][] grid, int[][][][] dp) {
        // log current call

        if (toggle > 2) {
            return 0;
        }
        if (dp[i][j][dir][toggle] != -1)
            return dp[i][j][dir][toggle];

        if (dir == 0 && grid[i][j] == 1) {
            int tl = 0, tr = 0, bl = 0, br = 0;

            if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 2) {
                tl = 1 + dfs(i - 1, j - 1, 1, 2, 1, grid, dp);
            }

            if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] == 2) {
                tr = 1 + dfs(i - 1, j + 1, 2, 2, 1, grid, dp);
            }

            if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] == 2) {
                bl = 1 + dfs(i + 1, j - 1, 3, 2, 1, grid, dp);
            }

            if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] == 2) {
                br = 1 + dfs(i + 1, j + 1, 4, 2, 1, grid, dp);
            }

            return dp[i][j][dir][toggle] = 1 + Math.max(tl, Math.max(tr, Math.max(bl, br)));
        }

        int going = 0, bend = 0;

        if (dir == 1) { // top-left
            if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 2 - prev) {
                going = 1 + dfs(i - 1, j - 1, 1, 2 - prev, toggle, grid, dp);
            }
            if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] == 2 - prev && toggle + 1 < 3) {
                bend = 1 + dfs(i - 1, j + 1, 2, 2 - prev, toggle + 1, grid, dp);
            }
        } else if (dir == 2) { // top-right
            if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] == 2 - prev) {
                going = 1 + dfs(i - 1, j + 1, 2, 2 - prev, toggle, grid, dp);
            }
            if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] == 2 - prev && toggle + 1 < 3) {
                bend = 1 + dfs(i + 1, j + 1, 4, 2 - prev, toggle + 1, grid, dp);
            }
        } else if (dir == 3) { // bottom-left
            if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] == 2 - prev) {
                going = 1 + dfs(i + 1, j - 1, 3, 2 - prev, toggle, grid, dp);
            }
            if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 2 - prev && toggle + 1 < 3) {
                bend = 1 + dfs(i - 1, j - 1, 1, 2 - prev, toggle + 1, grid, dp);
            }
        } else { // bottom-right
            if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] == 2 - prev) {
                going = 1 + dfs(i + 1, j + 1, 4, 2 - prev, toggle, grid, dp);
            }
            if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] == 2 - prev && toggle + 1 < 3) {
                bend = 1 + dfs(i + 1, j - 1, 3, 2 - prev, toggle + 1, grid, dp);
            }
        }

        return dp[i][j][dir][toggle] = Math.max(going, bend);

    }
}
