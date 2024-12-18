class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add( new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int des = edges[i][1];
            graph.get(src).add(des);
            graph.get(des).add(src);
        }
        int[] visited = new int[n];
        return dfs(source,graph,visited,destination);
        
    }
    public boolean dfs(int index,List<List<Integer>> graph,int[] visited,int destination){
        visited[index] = 1;
        if(visited[destination] == 1)return true;
        for(int i=0;i<graph.get(index).size();i++){
            if(visited[graph.get(index).get(i)] == 0){
                if(dfs(graph.get(index).get(i),graph,visited,destination)){
                    return true;
                }
            }
        }
        return false;
    }
}
