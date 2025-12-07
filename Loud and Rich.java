class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<quiet.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<richer.length;i++){
            int[] arr = richer[i];
            graph.get(arr[1]).add(arr[0]);
        }

        int[] result = new int[quiet.length];
        Arrays.fill(result,-1);
        int[] visited = new int[quiet.length];

        for(int i=0;i<quiet.length;i++){
            if(visited[i] == 0){
                dfs(i,visited,result,graph,quiet);
            }
        }
        return result;
    }
    public int dfs(int idx,int[] visited,int[] result,List<List<Integer>> graph,int[] quiet){
        visited[idx] = 1;

        List<Integer> list = graph.get(idx);

        int pos = idx;

        for(int val : list){

            int returnPos = result[val] != -1 ? result[val] : dfs(val,visited,result,graph,quiet);
            if(quiet[returnPos] < quiet[pos]){
                pos = returnPos;
            }
        }

        return result[idx] = pos;
    }
}
