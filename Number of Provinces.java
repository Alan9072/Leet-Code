class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length+1];
        int count = 0;
        for(int i=1;i<=isConnected.length;i++){
            if(visited[i] == 0){
                dfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }
    public void dfs(int index,int[] visited,int[][] isConnected){
        visited[index] = 1;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[index - 1][i] == 1 && visited[i+1] != 1){
                dfs(i+1,visited,isConnected);
            }
        }
    }
}
