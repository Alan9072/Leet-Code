class Pair {
    int i;
    int j;
    int weight;

    Pair(int i, int j, int weight) {
        this.i = i;
        this.j = j;
        this.weight = weight;
    }
}

class Solution {
    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] cost = new int[rows][cols];
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // Initialize cost array
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        heap.add(new Pair(0, 0, 0));
        cost[0][0] = 0;

        while (!heap.isEmpty()) {
            Pair curr = heap.poll();
            int i = curr.i;
            int j = curr.j;
            int weight = curr.weight;

            if (i == rows - 1 && j == cols - 1) {
                return weight;
            }

            if (weight > cost[i][j]) {
                continue;
            }

            // Move Down (3)
            if (i + 1 < rows) {
                int newCost = weight + (grid[i][j] == 3 ? 0 : 1);
                if (newCost < cost[i + 1][j]) {
                    cost[i + 1][j] = newCost;
                    heap.add(new Pair(i + 1, j, newCost));
                }
            }

            // Move Up (4)
            if (i - 1 >= 0) {
                int newCost = weight + (grid[i][j] == 4 ? 0 : 1);
                if (newCost < cost[i - 1][j]) {
                    cost[i - 1][j] = newCost;
                    heap.add(new Pair(i - 1, j, newCost));
                }
            }

            // Move Right (1)
            if (j + 1 < cols) {
                int newCost = weight + (grid[i][j] == 1 ? 0 : 1);
                if (newCost < cost[i][j + 1]) {
                    cost[i][j + 1] = newCost;
                    heap.add(new Pair(i, j + 1, newCost));
                }
            }

            // Move Left (2)
            if (j - 1 >= 0) {
                int newCost = weight + (grid[i][j] == 2 ? 0 : 1);
                if (newCost < cost[i][j - 1]) {
                    cost[i][j - 1] = newCost;
                    heap.add(new Pair(i, j - 1, newCost));
                }
            }
        }

        return 0;
    }
}
