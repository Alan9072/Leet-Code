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
