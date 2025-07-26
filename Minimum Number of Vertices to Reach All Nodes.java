class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] check = new int[n];
        List<Integer> result = new ArrayList<>();
        for(List<Integer> edge : edges){
            check[edge.get(1)] = 1;
        }

        for(int i=0;i<n;i++){
            if(check[i] == 0)result.add(i);
        }
        return result;
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] visited = new int[n];
        List<Integer> result = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            graph.get(edge.get(0)).add(edge.get(1));
        }

        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(graph,i,visited);
            }
        }
        
        for(int i=0;i<n;i++){
            if(visited[i] == 0)result.add(i);
        }
        return result;
    }
    public void dfs(List<List<Integer>> graph,int node,int[] visited){

        List<Integer> curr = graph.get(node);

        for(int i=0;i<curr.size();i++){
            int currNode = curr.get(i);
            if(visited[currNode] == 0){
                visited[currNode] = 1;
                dfs(graph,currNode,visited);
            }
        }

    }
}
