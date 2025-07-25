class Pair {
    int i;
    int j;
    int count;

    Pair(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}

class Solution {
    public int shortestBridge(int[][] grid) {
        // int[][] visited = new int[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        boolean valid = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    valid = true;
                    break;
                }
            }
            if(valid){
                break;
            }
        }

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            //four directions
            for (int direct[] : directions) {
                int i = curr.i + direct[0];
                int j = curr.j + direct[1];

                if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
                    if (grid[i][j] == 0) {
                        queue.add(new Pair(i, j, curr.count + 1));
                        grid[i][j] = 2; // for good reason;
                    } else if (grid[i][j] == 1) {
                        return curr.count;
                    }
                }

            }
        }
        return -1;

    }

    public int dfs(int[][] grid, int i, int j, Queue<Pair> queue) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 2)
            return -1;
        if (grid[i][j] == 0)
            return 0;

        grid[i][j] = 2;

        int left = dfs(grid, i, j - 1, queue);
        int right = dfs(grid, i, j + 1, queue);
        int top = dfs(grid, i - 1, j, queue);
        int bottom = dfs(grid, i + 1, j, queue);

        if (left == 0 || right == 0 || top == 0 || bottom == 0) {
            queue.add(new Pair(i, j, 0));
        }
        return -1;
    }
}
