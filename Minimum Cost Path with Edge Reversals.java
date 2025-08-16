class Pair {
    int dest;
    int cost;
    Pair(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], 2 * edge[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (visited[curr.dest] == 1) continue;
            visited[curr.dest] = 1;

            if (curr.dest == n - 1) return curr.cost;

            for (Pair edge : graph.get(curr.dest)) {
                if (visited[edge.dest] == 0) {
                    pq.add(new Pair(edge.dest, curr.cost + edge.cost));
                }
            }
        }
        return -1;
    }
}
©leetcode
