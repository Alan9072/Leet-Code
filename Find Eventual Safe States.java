class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[graph.length];
        int[] willSatisfy = new int[graph.length];
        Arrays.fill(visited, -1);
        Arrays.fill(willSatisfy, -1);

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) {
                if (safe(graph, i, willSatisfy, visited)) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public boolean safe(int[][] graph, int index, int[] willSatisfy, int[] visited) {
        if (willSatisfy[index] == 1) {
            return true; // Return true if already marked safe
        }

        visited[index] = 1; // Mark as visited temporarily

        for (int curr : graph[index]) {
            if (visited[curr] == 1 || !safe(graph, curr, willSatisfy, visited)) {
                willSatisfy[index] = 0; // Mark as unsafe
                return false;
            }
        }

        willSatisfy[index] = 1; // Mark as safe
        visited[index] = -1; // Reset visited state for future calls
        return true;
    }
}
