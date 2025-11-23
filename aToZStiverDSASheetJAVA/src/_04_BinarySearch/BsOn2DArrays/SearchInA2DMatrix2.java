package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOn2DArrays;
//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchInA2DMatrix2 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length, m = matrix[0].length, row = n-1, col = 0;

            while(row >= 0 && col < m){
                if(matrix[row][col] == target){
                    return true;
                }
                else if(matrix[row][col] > target){
                    row--;
                }
                else{
                    col++;
                }
            }

            return false;
        }
    }
}
