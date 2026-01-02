class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (worked(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean worked(int row, int col, int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (set.contains(num) || num > 9 || num <= 0)
                    return false;
                set.add(num);

                rowMap.put(i, rowMap.getOrDefault(i, 0) + num);
                colMap.put(j, colMap.getOrDefault(j, 0) + num);
            }
        }

        int sum = 0;
        for (int val : rowMap.values()) {
            if (sum == 0) {
                sum = val;
            }

            if (val != sum)
                return false;
        }

        for (int val : colMap.values()) {
            if (val != sum)
                return false;
        }

        //diagonal one
        int subSum = 0;
        for (int k = 0; k < 3; k++) {
            subSum += grid[row + k][col + k];
        }
        if (subSum != sum)
            return false;

        //diagonal two
        int subSum2 = 0;
        for (int k = 0; k < 3; k++) {
            subSum2 += grid[row + k][col + 2 - k];
        }
        if (subSum2 != sum)
            return false;

        return true;
    }
}
