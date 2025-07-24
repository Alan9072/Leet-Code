class Pair {
    int node;
    char color;
    int dist;
    Pair(int node, char color, int dist) {
        this.node = node;
        this.color = color;
        this.dist = dist;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result = new int[n];
        Arrays.fill(result,-1);
        result[0] = 0;

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<redEdges.length;i++){
            int[] curr = redEdges[i];
            graph.get(curr[0]).add(new Pair(curr[1],'r',0));
        }

        for(int i=0;i<blueEdges.length;i++){
            int[] curr = blueEdges[i];
            graph.get(curr[0]).add(new Pair(curr[1],'b',0));
        }


        int[][] visited = new int[n][2];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 'r', 0)); // Start from node 0 assuming red edge
        queue.add(new Pair(0, 'b', 0)); // Start from node 0 assuming blue edge

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentNode = current.node;
            char lastColor = current.color;
            int distanceSoFar = current.dist;

            int colorIndex = (lastColor == 'r') ? 0 : 1;

            if (visited[currentNode][colorIndex] == 1) {
                continue;
            }

            visited[currentNode][colorIndex] = 1;

            if (result[currentNode] == -1) {
                result[currentNode] = distanceSoFar;
            }

            // Check neighbors of the current node
            for (Pair neighbor : graph.get(currentNode)) {
                // Only go to neighbor if its edge color is different
                if (neighbor.color != lastColor) {
                    int nextColorIndex = (neighbor.color == 'r') ? 0 : 1;

                    // If neighbor not visited with that color
                    if (visited[neighbor.node][nextColorIndex] == 0) {
                        queue.add(new Pair(neighbor.node, neighbor.color, distanceSoFar + 1));
                    }
                }
            }
        }

        return result;

    }
}
