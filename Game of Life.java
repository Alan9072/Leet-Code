class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveOnes = liveOrNot(board, i - 1, j) + liveOrNot(board, i + 1, j)
                        + liveOrNot(board, i, j - 1) + liveOrNot(board, i, j + 1)
                        + liveOrNot(board, i - 1, j - 1) + liveOrNot(board, i - 1, j + 1)
                        + liveOrNot(board, i + 1, j - 1) + liveOrNot(board, i + 1, j + 1);
                if (board[i][j] == 1) {
                    if (liveOnes < 2 || liveOnes > 3) {
                        board[i][j] = 2;
                    }
                }else{
                    if(liveOnes == 3){
                        board[i][j] = 3;
                    }
                }

            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    public int liveOrNot(int[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (board[i][j] == 1 || board[i][j] == 2)
                return 1;
        }
        return 0;
    }
}
