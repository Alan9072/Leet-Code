class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                map.putIfAbsent(i-j,new ArrayList<>());
                map.get(i-j).add(grid[i][j]);
            }
        }
        for (int key : map.keySet()) {
            List<Integer> sub = map.get(key);
            if (key >= 0) Collections.sort(sub, Collections.reverseOrder());
            else Collections.sort(sub);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = map.get(i - j).remove(0);
            }
        }

        return grid;
    }
}©leetcode
