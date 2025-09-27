class Solution {
    public int findMax(int[][] mat, int n, int m, int col){
        int maxValue = -1, ind = -1;

        for(int i=0; i<n; i++){
            if(mat[i][col] > maxValue){
                maxValue = mat[i][col];
                ind = i;
            }
        }

        return ind;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length, low = 0, high = m-1;
        int[] ans = {-1,-1};
        while(low <= high){
            int mid = low + (high-low)/2;
            int maxRowIndex = findMax(mat, n, m, mid);
            int left = mid -1 >= 0 ? mat[maxRowIndex][mid-1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid+1] : -1;
            if(mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right){
                ans[0] = maxRowIndex;
                ans[1] = mid;
                break;
            }
            else if(mat[maxRowIndex][mid] < left){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}