class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];
        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            int r1 = query[0];
            int r2 = query[2];
            int c1 = query[1];
            int c2 = query[3];

            for(int j=r1;j<=r2;j++){
                result[j][c1]++;
                if(c2 + 1 < n){
                    result[j][c2 + 1]--;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                result[i][j] += result[i][j-1];
            }
        }
        return result;
    }
}
