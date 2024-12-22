class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer> stk = new Stack<>();

        int[] recStk = new int[numCourses];
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0){
                dfs(i,graph,visited,stk,recStk);
            }
        }
        if(stk.size() != numCourses){
            return new int[]{};
        }else{
            int result[] = new int[numCourses];
            int index = 0;
            while(!stk.isEmpty()){
                result[index] = stk.pop();
                index++;
            }
            return result;
        }
        
    }
    public boolean dfs(int index,List<List<Integer>> graph,int[] visited,Stack<Integer> stk,int[] recStk){
        if(recStk[index] == 1)return false;
        if(visited[index] == 1)return true;

        visited[index] = 1;
        recStk[index] = 1;
        for(int i=0;i<graph.get(index).size();i++){
            int curr = graph.get(index).get(i);
            if(!dfs(curr,graph,visited,stk,recStk))return false; 
        }
        stk.push(index);
        recStk[index] = 0;
        return true;
    }
}
