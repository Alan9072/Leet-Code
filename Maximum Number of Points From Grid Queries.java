class Pair {
    int val;
    int i;
    int j;

    Pair(int val, int i, int j) {
        this.val = val;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] sorted = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sorted[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);

        int[] result = new int[queries.length];

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        q.add(new Pair(grid[0][0], 0, 0));
        visited[0][0] = 1;

        int points = 0;

        for (int i = 0; i < sorted.length; i++) {

            while (!q.isEmpty() && q.peek().val < sorted[i][0]) {
                Pair curr = q.remove();
                points++;

                // Right
                if (curr.j + 1 < grid[0].length && visited[curr.i][curr.j + 1] == 0) {
                    visited[curr.i][curr.j + 1] = 1;
                    q.add(new Pair(grid[curr.i][curr.j + 1], curr.i, curr.j + 1));
                }
                // Left
                if (curr.j - 1 >= 0 && visited[curr.i][curr.j - 1] == 0) {
                    visited[curr.i][curr.j - 1] = 1;
                    q.add(new Pair(grid[curr.i][curr.j - 1], curr.i, curr.j - 1));
                }
                // Down
                if (curr.i + 1 < grid.length && visited[curr.i + 1][curr.j] == 0) {
                    visited[curr.i + 1][curr.j] = 1;
                    q.add(new Pair(grid[curr.i + 1][curr.j], curr.i + 1, curr.j));
                }
                // Up
                if (curr.i - 1 >= 0 && visited[curr.i - 1][curr.j] == 0) {
                    visited[curr.i - 1][curr.j] = 1;
                    q.add(new Pair(grid[curr.i - 1][curr.j], curr.i - 1, curr.j));
                }
            }

            result[sorted[i][1]] = points;
        }

        return result;
    }
}
