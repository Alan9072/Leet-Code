class Solution {
    Map<Integer, Integer> gridFind = new HashMap<>();
    Map<Integer, TreeSet<Integer>> grid = new HashMap<>();

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] visited = new int[c + 1];
        List<Integer> subResult = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int arr[] = connections[i];
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        int idAssign = 1;
        for (int i = 1; i <= c; i++) {
            if (visited[i] == 0) {
                dfs(i, graph, visited, idAssign);
                idAssign++;
            }
        }

        //process the queries
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int id = gridFind.get(query[1]);
            TreeSet<Integer> list = grid.get(id);
            if (query[0] == 1) {
                if(list.contains(query[1])){
                    subResult.add(query[1]);
                }else{
                    if(list.size() == 0){
                        subResult.add(-1);
                    }else{
                        subResult.add(list.first());
                    }
                }
            } else {
                list.remove(query[1]);
            }
        }

        int[] result = new int[subResult.size()];
        for(int i=0;i<result.length;i++){
            result[i] = subResult.get(i);
        }
        return result;
    }

    public void dfs(int idx, List<List<Integer>> graph, int[] visited, int idAssign) {
        if (visited[idx] == 1)
            return;

        visited[idx] = 1;
        gridFind.put(idx, idAssign);
        grid.putIfAbsent(idAssign, new TreeSet<>());
        grid.get(idAssign).add(idx);

        for (int i = 0; i < graph.get(idx).size(); i++) {
            int curr = graph.get(idx).get(i);
            dfs(curr, graph, visited, idAssign);
        }
    }
}
