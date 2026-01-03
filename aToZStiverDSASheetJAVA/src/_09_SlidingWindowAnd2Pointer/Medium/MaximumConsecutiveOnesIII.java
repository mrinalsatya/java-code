package aToZStiverDSASheetJAVA.src._09_SlidingWindowAnd2Pointer.Medium;
//https://leetcode.com/problems/max-consecutive-ones-iii/
//Time Complexity: O(n)
//
//Space Complexity: O(1)

//Key Interview Explanation
//
//Uses sliding window with two pointers
//
//Keeps count of zeros in the window
//
//Allows flipping at most k zeros
//
//Expands window when valid, shrinks when invalid
public class MaximumConsecutiveOnesIII {
    class Solution {
        public int longestOnes(int[] nums, int k) {

            int n = nums.length;

            // Left and right pointers of the sliding window
            int l = 0, r = 0;

            // Maximum length of valid window found so far
            int maxLen = 0;

            // Number of zeros in the current window
            int zeroes = 0;

            // Expand window using right pointer
            while (r < n) {

                // If current element is zero, increase zero count
                if (nums[r] == 0) {
                    zeroes++;
                }

                // If zeros exceed allowed flips, shrink window from left
                if (zeroes > k) {

                    // If the left element is zero, reduce zero count
                    if (nums[l] == 0) {
                        zeroes--;
                    }

                    // Move left pointer forward
                    l++;
                }

                // If window has at most k zeros, update maximum length
                if (zeroes <= k) {
                    int len = r - l + 1;
                    maxLen = Math.max(maxLen, len);
                }

                // Move right pointer forward
                r++;
            }

            return maxLen;
        }
    }

}
