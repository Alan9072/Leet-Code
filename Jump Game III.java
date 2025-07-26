class Solution {
    public boolean canReach(int[] arr, int start) {
        int[] visited = new int[arr.length];
        return dfs(start,arr,visited);
    }
    public boolean dfs(int start,int[] arr,int[] visited){
        if(start < 0 || start >= arr.length || visited[start] == 1)return false;

        if(arr[start] == 0)return true;

        visited[start] = 1;

        if(dfs(start - arr[start],arr,visited) || dfs(start + arr[start],arr,visited)){
            return true;
        }

        return false;
    }
}
