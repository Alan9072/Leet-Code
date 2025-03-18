class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        boolean[] rows = new boolean[n];
        boolean[] columns = new boolean[n];

        solve(board, rows, columns, 0, n, 0);
        return result;

    }

    public void solve(char[][] board, boolean[] rows, boolean[] columns, int rownum, int n, int count) {
        if (count == n) {
            List<String> sub = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder("");
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                sub.add(sb.toString());
            }
            result.add(sub);
            return;
        }

        // int valid = 0;
        for (int k = 0; k < n; k++) {

            if (rows[rownum] == true) {

                continue;
            }
            if (columns[k] == true) {

                continue;
            }

            int dValidity = 1;

            // to top left -
            int x = rownum - 1;
            int y = k - 1;
            while (x >= 0 && y >= 0) {
                if (board[x][y] == 'Q') {
                    dValidity = 0;
                    break;
                }
                x--;
                y--;
            }

            // to top right
            x = rownum - 1;
            y = k + 1;
            while (x >= 0 && y < n) {
                if (board[x][y] == 'Q') {
                    dValidity = 0;
                    break;
                }
                x--;
                y++;
            }

            if (dValidity == 0) {
                continue;
            } else {
                board[rownum][k] = 'Q';
                rows[rownum] = true;
                columns[k] = true;
                solve(board, rows, columns, rownum + 1, n, count + 1);
                rows[rownum] = false;
                columns[k] = false;
                board[rownum][k] = '.';
            }
        }
    }
}
