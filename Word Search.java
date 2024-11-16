class Solution {
    
    Boolean isThere = false;

    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder("");
        if (board.length == 1 && board[0].length == 1 && (board[0][0] + "").equals(word)) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isthere(board, word, 0, i, j, sb);
                }
            }
        }
        return isThere;
    }

    public void isthere(char[][] board, String word, int index, int row, int column, StringBuilder abc) {
        if (index == word.length()) {
            if (word.equals(abc.toString())) {
                isThere = true;
            }
            return;
        }

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word.charAt(index)) {
            return;
        }

        abc.append(board[row][column]);

        char temp = board[row][column];
        board[row][column] = '#';

        isthere(board, word, index + 1, row, column - 1, abc);
        isthere(board, word, index + 1, row, column + 1, abc); 
        isthere(board, word, index + 1, row - 1, column, abc); 
        isthere(board, word, index + 1, row + 1, column, abc); 

        abc.deleteCharAt(abc.length() - 1 );
        board[row][column] = temp;
    }
}
