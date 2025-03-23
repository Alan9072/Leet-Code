class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        int connected = 0;
        boolean visited[] = new boolean[properties.length];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<properties.length;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<properties.length;i++){
            for(int j=0;j<properties.length;j++){
                if(i == j)continue;
                else if(intersect(properties[i],properties[j]) >= k){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
                
            }
        }
        for(int i=0;i<graph.size();i++){
            if(visited[i] == false){
                dfs(graph,visited,i);
                connected++;
            }
            
        }
        return connected;
    }
    public void dfs(List<List<Integer>> graph,boolean[] visited,int index){
        if(visited[index] == true)return;
        
        visited[index] = true;
        for(int i=0;i<graph.get(index).size();i++){
            dfs(graph,visited,graph.get(index).get(i));
        }
    }
     public int intersect(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> common = new ArrayList<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            if (set1.contains(num)) {
                common.add(num);
                set1.remove(num); // Avoid duplicates
            }
        }

        return common.size();
    }
}
