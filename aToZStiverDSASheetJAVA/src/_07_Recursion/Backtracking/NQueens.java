package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;
//https://leetcode.com/problems/n-queens/
public class NQueens {
    List<List<String>> ans = new ArrayList<>();
    public void placeQueens(int col, char[][] board, boolean[] leftRow, boolean[] upperDiag, boolean[] lowerDiag){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(!leftRow[row] && !upperDiag[row+col] && !lowerDiag[board.length -1 + col - row])
            {
                board[row][col] = 'Q';
                leftRow[row] = true;
                upperDiag[row+col] = true;
                lowerDiag[board.length -1 + col - row] = true;

                placeQueens(col+1, board, leftRow, upperDiag, lowerDiag);

                board[row][col] = '.';
                leftRow[row] = false;
                upperDiag[row+col] = false;
                lowerDiag[board.length -1 + col - row] = false;
            }
        }
    }
    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i = 0; i<board.length; i++){
            res.add(new String(board[i]));
        }

        return res;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i =0; i< n; i++){
            Arrays.fill(board[i], '.');
        }

        boolean[] leftRow = new boolean[n];
        boolean[] upperDiag = new boolean[2*n];
        boolean[] lowerDiag = new boolean[2*n];

        placeQueens(0, board, leftRow, upperDiag, lowerDiag);

        return ans;
    }
}
