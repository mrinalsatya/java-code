package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOn1DArray;

public class LowerBound {
    class Solution {
        int lowerBound(int[] arr, int target) {
            // code here
            int ans = arr.length;
            int low = 0, high = arr.length-1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(arr[mid] >= target){
                    ans = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            return ans;
        }
    }
}
