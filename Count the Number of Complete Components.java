class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int completeConnected = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] arr = edges[i];
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        for (int i = 0; i < graph.size(); i++) {
            if (visited[i] == 0) {

                HashSet<Integer> nodes = new HashSet<>();
                HashSet<String> edge = new HashSet<>();
                dfs(i, nodes, edge, visited, graph);
                int noEdge = edge.size();
                int noNodes = nodes.size();
                

                if (noEdge == noNodes * (noNodes - 1) / 2) {
                    completeConnected++;
                }
            }

        }
        return completeConnected;
    }

    public void dfs(int node, HashSet<Integer> nodes, HashSet<String> edge, int[] visited, List<List<Integer>> graph) {
        
        if (visited[node] == 0) {
            visited[node] = 1;
            nodes.add(node);
        } else {
            return;
        }

        for (int i = 0; i < graph.get(node).size(); i++) {
            int neighbor = graph.get(node).get(i);
            String edgePair = node + "-" + neighbor; // Normalize edge

            if (!edge.contains(edgePair) && !edge.contains(neighbor + "-" + node)) {
                edge.add(edgePair);
                dfs(neighbor, nodes, edge, visited, graph);
            }
        }
        return;

    }
}
