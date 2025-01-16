////////////////////Recursion With Memoization///////////////////////////////////
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n]; 
        for (int i = 0; i < m; i++) {
            Arrays.fill(arr[i], -1);
        }

        return paths(0, 0, m, n, arr);
    }

    public int paths(int i, int j, int end1, int end2, int[][] arr) {
        if (i == end1 - 1 || j == end2 - 1) {
            return 1;
        }
        if (i == end1 || j == end2) {
            return 0;
        }
        if (arr[i][j] != -1) {
            return arr[i][j];
        }

        int right = paths(i + 1, j, end1, end2, arr);
        int bottom = paths(i, j + 1, end1, end2, arr);
        arr[i][j] = right + bottom;

        return right + bottom;
    }
}

/////////////////////Tabulation ////////////////////////
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; 

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else{
                    int up = 0;
                    if( i - 1  >= 0){
                        up = dp[i - 1][j];
                    } 
                    int left = 0;
                    if( j - 1  >= 0){
                        left = dp[i][j - 1];
                    }

                    dp[i][j] = left + up;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
