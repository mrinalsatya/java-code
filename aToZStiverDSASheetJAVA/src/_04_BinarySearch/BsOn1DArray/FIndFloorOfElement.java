package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOn1DArray;

public class FIndFloorOfElement {
    class Solution {
        public int findFloor(int[] arr, int x) {
            // code here
            int n = arr.length, low = 0, high = n-1;
            int ans = -1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(arr[mid] <= x){
                    ans =  mid;
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }

            }
            return ans;
        }
    }

}
