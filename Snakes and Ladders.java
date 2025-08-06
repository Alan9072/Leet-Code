class Pair {
    int val;
    int dist;
    Pair(int val, int dist) {
        this.val = val;
        this.dist = dist;
    }
}

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1];
        int[] visited = new int[arr.length];

        boolean trigger = true;
        int start = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (trigger) {
                for (int j = 0; j < n; j++) {
                    arr[start] = board[i][j];
                    start++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    arr[start] = board[i][j];
                    start++;
                }
            }
            trigger = !trigger;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        visited[1] = 1;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int val = curr.val;
            int dist = curr.dist;

            if (val == n * n) return dist;

            for (int i = val + 1; i <= Math.min(val + 6, n * n); i++) {
                int destination = (arr[i] == -1) ? i : arr[i];

                if (visited[destination] == 1) continue;

                visited[destination] = 1;
                q.add(new Pair(destination, dist + 1));
            }
        }

        return -1;
    }
}
