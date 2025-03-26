class Solution {
    public int minOperations(int[][] grid, int x) {
        int length = grid.length*grid[0].length;
        int[] result = new int[length];
        int i=0;
        for(int j=0;j<grid.length;j++){
            for(int k=0;k<grid[0].length;k++){
                result[i] = grid[j][k];
                i++;
            }
        }
        Arrays.sort(result);
        if(x == 1){
            int count = 0;
            int mid = (length) / 2;
            for(int k=0;k<length;k++){
                count +=  Math.abs(result[mid] - result[k]);
            }
            return count;

        }else{
            
            for(int k=1;k<result.length;k++){
                if(result[k] % x  != result[k-1] % x){
                    return -1;
                }
            }
            int count = 0;
            int mid = (length) / 2;
            for(int k=0;k<length;k++){
                count +=  Math.abs((result[mid] - result[k])/x);
            }
            return count;

        }
    }
}
