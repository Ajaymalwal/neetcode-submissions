class Solution {
    public void solve(char[][] board) {
         int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1){
                    dfs(i,j,board);
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

         for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') return;
        board[r][c] = 'S';
        dfs(r+1,c,board);
        dfs(r,c+1,board);
        dfs(r-1,c,board);
        dfs(r,c-1,board);
        return;
    }
}