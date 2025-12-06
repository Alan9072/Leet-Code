class Pair {
    int node;
    int time;

    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class State {
    int city;
    int totalTime;
    int totalCost;

    State(int city, int totalTime, int totalCost) {
        this.city = city;
        this.totalTime = totalTime;
        this.totalCost = totalCost;
    }
}

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], t = edge[2];
            graph.get(u).add(new Pair(v, t));
            graph.get(v).add(new Pair(u, t));
        }

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.totalCost - b.totalCost);
        pq.offer(new State(0, 0, passingFees[0]));

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            if (curr.totalTime > maxTime)
                continue;

            if (curr.city == n - 1)
                return curr.totalCost;

            for (Pair neighbor : graph.get(curr.city)) {
                int nextCity = neighbor.node;
                int nextTime = curr.totalTime + neighbor.time;
                int nextCost = curr.totalCost + passingFees[nextCity];

                if (nextTime < minTime[nextCity]) {
                    minTime[nextCity] = nextTime;
                    pq.offer(new State(nextCity, nextTime, nextCost));
                }
            }
        }
        return -1;
    }
}
