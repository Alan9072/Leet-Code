class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int arr[] = prerequisites[i];
            graph.get(arr[1]).add(arr[0]);
        }
        int[] visited = new int[numCourses];
        int[] recStk = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0){
                if(!dfs(i,visited,recStk,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int index,int[] visited,int[] recStk,List<List<Integer>> graph){
        if(recStk[index] == 1){
            return false;
        }
        if(visited[index] == 1)return true;
        
        visited[index] = 1;
        recStk[index] = 1;
        for(int i=0;i<graph.get(index).size();i++){
            if(!dfs(graph.get(index).get(i),visited,recStk,graph)){
                    recStk[index] = 0;
                    return false;
                }
        }
        recStk[index] = 0;
        return true;
    }
}
