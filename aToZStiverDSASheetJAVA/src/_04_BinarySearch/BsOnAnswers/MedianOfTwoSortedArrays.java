package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOnAnswers;
//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {
    //Brute force will be taking 3rd array of size n1+n2, and merge 2 sorted arrays into 3rd and find the median;
//Better will be to optimise it and reduce the extra space by taking variables;
//Optimal is binary search O(min(logn,logm))  - smaller array size
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int n1 = nums1.length;
            int n2 = nums2.length;
            int n = n1 + n2;

            // Always binary–search on the smaller array to avoid index overflow
            if (n1 > n2) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int low = 0, high = n1;

            // Total elements on the LEFT half of the merged sorted array
            // For odd: left has one extra element
            int left = (n1 + n2 + 1) / 2;

            while (low <= high) {

                // mid1 = how many elements we take from nums1
                int mid1 = low + (high - low) / 2;

                // mid2 = how many elements we must take from nums2
                // so that left partition has exactly 'left' elements
                int mid2 = left - mid1;

                // LEFT side max of nums1
                int l1 = (mid1 - 1 >= 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;

                // LEFT side max of nums2
                int l2 = (mid2 - 1 >= 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;

                // RIGHT side min of nums1
                int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;

                // RIGHT side min of nums2
                int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

                // ✔ Partition is correct when:
                //   all left elements ≤ all right elements
                if (l1 <= r2 && l2 <= r1) {

                    // If total count is odd → median is max of LEFT half
                    if (n % 2 == 1) {
                        return Math.max(l1, l2);
                    }

                    // If even → median is avg of max(Left) + min(Right)
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                // If left1 > right2: we took too many from nums1 → shrink
                else if (l1 > r2) {
                    high = mid1 - 1;
                }

                // Else we took too few from nums1 → expand
                else {
                    low = mid1 + 1;
                }
            }

            return 0; // Should never reach here
        }
    }

}
