class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int key = i - j;
                if(!map.containsKey(key)){
                    map.put(key,new PriorityQueue<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                
                int val = map.get(i - j).poll();
                mat[i][j] = val;
            }
        }

        return mat;
    }
}
