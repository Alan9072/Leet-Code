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
    public int[][] highestPeak(int[][] isWater) {
        Queue<Pair> q = new LinkedList<>();

        int n = isWater.length;
        int m = isWater[0].length;
        int[][] visited = new int[n][m];

        // Initialize the queue with water cells and mark them as visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Pair(0, i, j)); // Start with height 0 for water cells
                    isWater[i][j] = 0;
                    visited[i][j] = 1;
                }
            }
        }

        // Perform BFS
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int curri = curr.i;
            int currj = curr.j;
            int currVal = curr.val;

            // Check all four directions manually
            if (curri + 1 < n && visited[curri + 1][currj] == 0) { // Down
                q.add(new Pair(currVal + 1, curri + 1, currj));
                isWater[curri + 1][currj] = currVal + 1;
                visited[curri + 1][currj] = 1;
            }
            if (curri - 1 >= 0 && visited[curri - 1][currj] == 0) { // Up
                q.add(new Pair(currVal + 1, curri - 1, currj));
                isWater[curri - 1][currj] = currVal + 1;
                visited[curri - 1][currj] = 1;
            }
            if (currj + 1 < m && visited[curri][currj + 1] == 0) { // Right
                q.add(new Pair(currVal + 1, curri, currj + 1));
                isWater[curri][currj + 1] = currVal + 1;
                visited[curri][currj + 1] = 1;
            }
            if (currj - 1 >= 0 && visited[curri][currj - 1] == 0) { // Left
                q.add(new Pair(currVal + 1, curri, currj - 1));
                isWater[curri][currj - 1] = currVal + 1;
                visited[curri][currj - 1] = 1;
            }
        }

        return isWater;
    }
}
