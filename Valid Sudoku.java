class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            int rowSize = 0;
            int colSize = 0;

            for (int j = 0; j < board.length; j++) {
                
                if (board[i][j] != '.') {
                    rowSet.add(board[i][j]);
                    rowSize++;
                }

                if (board[j][i] != '.') {
                    colSet.add(board[j][i]);
                    colSize++;
                }
            }

            if (rowSet.size() != rowSize || colSet.size() != colSize) {
                return false;
            }
        }

        int yaxis = 0;
        for (int k = 0; k < 3; k++) {

            int xaxis = 0;
            for (int l = 0; l < 3; l++) {
                HashSet<Character> set3 = new HashSet<>();
                int size = 0;
                for (int i = yaxis; i < yaxis + 3; i++) {

                    for (int j = xaxis; j < xaxis + 3; j++) {
                        if (board[i][j] == '.')
                            continue;
                        else {
                            set3.add(board[i][j]);
                            size++;
                        }
                    }

                }

                if (!(set3.size() == size))
                    return false;
                xaxis = xaxis + 3;
            }
            yaxis = yaxis + 3;
        }

        return true;
    }
}
