class Pair {
    int dest;
    int col;

    Pair(int dest, int col) {
        this.dest = dest;
        this.col = col;
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, 0));

                while (!q.isEmpty()) {
                    Pair curr = q.poll();
                    int node = curr.dest;
                    int col = curr.col;

                    color[node] = col;

                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            q.add(new Pair(neighbor, 1 - col));
                        } else if (color[neighbor] == col) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
