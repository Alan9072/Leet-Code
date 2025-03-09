class Solution {
    public void solveSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[][] boxes = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxes[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows[i].add(board[i][j]);
                    columns[j].add(board[i][j]);
                    boxes[i / 3][j / 3].add(board[i][j]);
                }
            }
        }

        solve(board, rows, columns, boxes, 0, 0);
    }

    private boolean solve(char[][] board, HashSet<Character>[] rows, HashSet<Character>[] columns, HashSet<Character>[][] boxes, int i, int j) {
        if (i == 9) return true; 
        if (j == 9) return solve(board, rows, columns, boxes, i + 1, 0);

        if (board[i][j] != '.') {
            return solve(board, rows, columns, boxes, i, j + 1);
        }

        for (char k = '1'; k <= '9'; k++) {
            if (!rows[i].contains(k) && !columns[j].contains(k) && !boxes[i / 3][j / 3].contains(k)) {
                board[i][j] = k;
                rows[i].add(k);
                columns[j].add(k);
                boxes[i / 3][j / 3].add(k);

                if (solve(board, rows, columns, boxes, i, j + 1)) {
                    return true;
                }

                board[i][j] = '.';
                rows[i].remove(k);
                columns[j].remove(k);
                boxes[i / 3][j / 3].remove(k);
            }
        }

        return false;
    }
}
