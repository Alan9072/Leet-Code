class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> min = new HashSet<>();
        HashSet<Integer> max = new HashSet<>();
        
        for(int i=0;i<matrix.length;i++){
            int minimum = Integer.MAX_VALUE;
            for(int j=0;j<matrix[i].length;j++){
                minimum = Math.min(minimum,matrix[i][j]);
            }
            min.add(minimum);
        }
        for(int i=0;i<matrix[0].length;i++){
            int maximum = 0;
            for(int j=0;j<matrix.length;j++){
                maximum = Math.max(maximum,matrix[j][i]);
            }
            max.add(maximum);
        }
        for(int val : min){
            if(max.contains(val)){
                result.add(val);
            }
        }
        return result;
    }
}
