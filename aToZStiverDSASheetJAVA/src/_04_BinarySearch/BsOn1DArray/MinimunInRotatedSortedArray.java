package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOn1DArray;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinimunInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int low = 0, high = nums.length - 1;

            while(low < high) {
                int mid = low + (high - low) / 2;

                // If mid element is greater than high, min must be in right half
                if(nums[mid] > nums[high]) {
                    low = mid + 1;
                }
                // Else min is in left half (including mid)
                else {
                    high = mid;
                }
            }

            return nums[low]; // low == high
        }
    }

}
