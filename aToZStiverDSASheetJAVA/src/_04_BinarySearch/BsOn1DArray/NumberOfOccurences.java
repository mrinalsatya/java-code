package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOn1DArray;

public class NumberOfOccurences {
    class Solution {
        int countFreq(int[] arr, int target) {
            // code here
            int left,right, n = arr.length;
            left = findLeft(arr, target, n);
            right = findRight(arr, target, n);

            int diff = right - left + 1;
            return (left == right && left == -1) ? left+1 : diff;
        }

        int findLeft(int[] arr, int target, int n){
            int low = 0, high = n-1, ans = -1;

            while(low<=high){
                int mid = low + (high-low)/2;
                if(arr[mid] == target){
                    ans = mid;
                    high = mid - 1;
                }else if(arr[mid] > target){
                    high = mid -1;
                }else{
                    low = mid+1;
                }
            }

            return ans;
        }

        int findRight(int[] arr, int target, int n){
            int low = 0, high = n-1, ans = -1;

            while(low<=high){
                int mid = low + (high-low)/2;
                if(arr[mid] == target){
                    ans = mid;
                    low = mid + 1;
                }else if(arr[mid] > target){
                    high = mid -1;
                }else{
                    low = mid+1;
                }
            }

            return ans;
        }
    }

}
