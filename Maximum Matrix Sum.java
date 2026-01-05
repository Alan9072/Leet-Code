class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negC = 0;
        int maxNeg = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int curr = matrix[i][j];
                if(curr <= 0){
                    negC++;
                }
                maxNeg = Math.min(Math.abs(curr),maxNeg);
                sum += Math.abs(curr);
            }
        }

        if(negC % 2 == 0){
            return sum;
        }else{
            return sum - 2 * maxNeg;
        }

    }
}
