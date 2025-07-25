
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }
        return dfs(headID, graph, informTime);
    }

    public int dfs(int node, List<List<Integer>> graph, int[] informTime) {
        int max = 0;
        for (int child : graph.get(node)) {
            max = Math.max(max, dfs(child, graph, informTime));
        }
        return informTime[node] + max;
    }
}
