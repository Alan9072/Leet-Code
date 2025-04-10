class Solution {
    int count = 0;

    public int minReorder(int n, int[][] connections) {

        Set<String> set = new HashSet<>();
        int visited[] = new int[connections.length + 1];
        for (int i = 0; i < connections.length; i++) {
            int[] curr = connections[i];
            set.add(curr[0] + "#" + curr[1]);
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < connections.length + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int[] curr = connections[i];
            graph.get(curr[0]).add(curr[1]);
            graph.get(curr[1]).add(curr[0]);
        }
        dfs(graph, 0, set, visited);
        return count;
    }

    public void dfs(List<List<Integer>> graph, int index, Set<String> set, int[] visited) {

        if (visited[index] == 1)
            return;

        visited[index] = 1;

        for (int i = 0; i < graph.get(index).size(); i++) {
            int curr = graph.get(index).get(i);
            if (visited[curr] == 0) {
                if (set.contains(index + "#" + curr)) {
                    count++;
                }
                dfs(graph, curr, set, visited);
            }

        }
    }
}
