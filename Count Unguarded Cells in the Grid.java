class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char arr[][] = new char[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '#';
            }
        }
        int pos = 0,pos1 = 0;
        for (int i = 0; i < walls.length; i++) {
            pos = walls[i][0];
            pos1 = walls[i][1];
            arr[pos][pos1] = 'W';
        }
        for (int i = 0; i < guards.length; i++) {
            pos = guards[i][0];
            pos1 = guards[i][1];
            arr[pos][pos1] = 'G';
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G') {
                    int a = i+1;
                    int b = j;
                    while (a >= 0 && a < m && b >= 0 && b < n && arr[a][b] != 'W' && arr[a][b] != 'G') {
                        arr[a][b] = 'V';
                        a++;
                    }
                    a = i-1;b = j;
                    while (a >= 0 && a < m && b >= 0 && b < n && arr[a][b] != 'W' && arr[a][b] != 'G') {
                        
                        arr[a][b] = 'V';
                        a--;
                    }
                    a = i;b = j+1;
                    while (a >= 0 && a < m && b >= 0 && b < n && arr[a][b] != 'W' && arr[a][b] != 'G') {
                        
                        arr[a][b] = 'V';
                        b++;
                    }
                    a = i;b = j-1;
                    while (a >= 0 && a < m && b >= 0 && b < n && arr[a][b] != 'W' && arr[a][b] != 'G') {

                        arr[a][b] = 'V';
                        b--;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == '#')count++;
            }
            
        }
        return count;
        
    }
}
