class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] prefix = new int[mat.length][mat[0].length];
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                prefix[i][j] = mat[i][j];

                if(i > 0)prefix[i][j] += prefix[i-1][j];
                if(j > 0)prefix[i][j] += prefix[i][j-1];
                if(i > 0 && j > 0)prefix[i][j] -= prefix[i-1][j-1];
            }
        }
        int result = 0;

        int left = 1;
        int right = Math.min(mat.length,mat[0].length);
        while(left <= right){
            int mid = left + (right - left)/2;
            if(possible(mid,prefix,threshold)){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
    public boolean possible(int side,int[][] prefix,int threshold){
        for(int i=0;i<=prefix.length - side;i++){
            for(int j=0;j<=prefix[0].length - side;j++){
                int sum = prefix[i + side - 1][j + side - 1];
                if(i > 0)sum -= prefix[i-1][j + side - 1];
                if(j > 0)sum -= prefix[i + side - 1][j-1];
                if(i > 0 && j > 0)sum += prefix[i-1][j-1];

                if(sum <= threshold)return true;
            }
        }
        return false;
    }
}
