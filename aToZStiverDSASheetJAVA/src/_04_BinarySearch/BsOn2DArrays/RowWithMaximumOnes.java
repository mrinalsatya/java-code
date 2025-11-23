package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOn2DArrays;
//https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2
public class RowWithMaximumOnes {
    // User function Template for Java

    class Solution {
        public int findFirstOccurance(int[] nums){
            int n = nums.length, ans = n, low = 0, high = n-1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(nums[mid] == 1){
                    ans = mid;
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

            return ans;
        }

        public int rowWithMax1s(int mat[][]) {
            // code here
            int n = mat.length, m = mat[0].length, ind = -1, maxOneCount = 0;

            for(int i = 0; i<n; i++){
                int currInd = findFirstOccurance(mat[i]);
                int currOneCount = m - currInd ;

                if(currOneCount > maxOneCount){
                    maxOneCount = currOneCount;
                    ind = i;
                }
            }


            return ind;

        }
    }
}
