package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;
//https://leetcode.com/problems/n-queens-ii/
public class NQueensCount {
    int ans = 0;
    public void solve(int col, int n, boolean[] leftRow, boolean[] upperDiag, boolean[] lowerDiag){
        if(col == n){
            ans++;
            return;
        }

        for(int row =0; row < n; row++){
            if(!leftRow[row] && !upperDiag[row+col] && !lowerDiag[n-1 + col -row]){
                leftRow[row] = true;
                upperDiag[row+col] = true;
                lowerDiag[n-1 + col -row] = true;

                solve(col+1, n, leftRow, upperDiag, lowerDiag);
                leftRow[row] = false;
                upperDiag[row+col] = false;
                lowerDiag[n-1 + col -row] = false;
            }
        }
    }
    public int totalNQueens(int n) {
        boolean[] leftRow = new boolean[n];
        boolean[] upperDiag = new boolean[2*n];
        boolean[] lowerDiag = new boolean[2*n];

        solve(0, n, leftRow, upperDiag, lowerDiag);

        return ans;
    }
}
