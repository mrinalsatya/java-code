//Solution 1 - Using Extra space
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length, m = matrix.length;

        int[] rows = new int[m];
        int[] cols = new int[n];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j< n; j++){
                if(matrix[i][j] == 0){
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j< n; j++){
                if(rows[i] == -1 || cols[j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}

//Solution 2 - Without Extra space


class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length, m = matrix.length;
        int col0 = 1;
        
        for(int i = 0; i<m; i++){
            if(matrix[i][0] == 0){
                col0 = 0;
            }
            for(int j = 1; j< n; j++){
                if(matrix[i][j] == 0){
                    //mark the i-th row
                    matrix[i][0] = 0;
                    //mark the j-th column
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            
            if(col0 == 0){
                matrix[i][0] = 0;
            }
        }

    }
}