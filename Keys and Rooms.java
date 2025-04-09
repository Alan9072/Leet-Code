class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];

        dfs(rooms,0,visited);
        for(int val : visited){
            if(val == 0)return false;
        }
        return true;

    }
    public void dfs(List<List<Integer>> rooms,int index,int[] visited){

        if(visited[index] == 1)return;

        visited[index] = 1;

        for(int i=0;i<rooms.get(index).size();i++){
            dfs(rooms,rooms.get(index).get(i),visited);
        }
    }
}
