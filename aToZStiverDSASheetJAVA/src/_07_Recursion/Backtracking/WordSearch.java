package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;
//https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean helper(char[][] board, int i, int j, String word, int ind){
        if(ind == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind))
            return false;

        char temp = word.charAt(ind);
        board[i][j] = '.';

        if(helper(board, i+1, j, word, ind+1) || helper(board, i, j+1, word, ind+1) || helper(board, i-1, j, word, ind+1) || helper(board, i, j-1, word, ind+1)){
            return true;
        }

        board[i][j] = temp;

        return false;

    }
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(helper(board, i, j, word , 0))
                    return true;
            }
        }
        return false;
    }
}
