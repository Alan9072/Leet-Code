class Solution {
    public void solve(char[][] board) {
        int m = board.length - 1;
        int n = board[0].length - 1;
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O')
                check(board, 0, j);
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[m][j] == 'O')
                check(board, m, j);
        }
        for (int j = 0; j < board.length; j++) {
            if (board[j][0] == 'O')
                check(board, j, 0);
        }
        for (int j = 0; j < board.length; j++) {
            if (board[j][n] == 'O')
                check(board, j, n);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void check(char[][] board, int i, int j) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 'X' || board[i][j] == 'V')
            return;

        board[i][j] = 'V';

        check(board, i + 1, j);
        check(board, i - 1, j);
        check(board, i, j + 1);
        check(board, i, j - 1);

    }
}
