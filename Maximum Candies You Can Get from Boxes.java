class Solution {
    int total = 0;
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        
        int[] visited = new int[status.length];
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> closedBoxes = new HashSet<>();

        for(int i=0;i<initialBoxes.length;i++){
            int curr = initialBoxes[i];
            dfs(curr,set,status,keys,containedBoxes,visited,candies,closedBoxes);
        }
        return total;
    }
    public void dfs(int index,HashSet<Integer> set,int[] status,int[][] keys,int[][] containedBoxes,int[] visited,int[] candies,HashSet<Integer> closedBoxes){
        if(visited[index] == 1)return;
        if(status[index] == 0){
            if(!set.contains(index)){
                closedBoxes.add(index);
                return;
            }
        }

        visited[index] = 1;
        total += candies[index];

        for(int i=0;i<keys[index].length;i++){
            int currKey = keys[index][i];
            set.add(keys[index][i]);
            if(closedBoxes.contains(currKey)){
                dfs(currKey,set,status,keys,containedBoxes,visited,candies,closedBoxes);
            }
        }


        for(int i=0;i<containedBoxes[index].length;i++){
            int box = containedBoxes[index][i];
            dfs(box,set,status,keys,containedBoxes,visited,candies,closedBoxes);
        }
    }
}
