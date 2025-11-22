package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOnAnswers;
//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
public class FindSmallestDivisor {
    class Solution {
        public static boolean isPossible(int[] nums, int threshold, int divisor){
            int sum = 0;
            for(int num: nums){
                sum += (num + divisor - 1)/divisor;
                if(sum > threshold) return false;
            }

            return true;
        }
        public int smallestDivisor(int[] nums, int threshold) {
            int n = nums.length, sum = 0, low = 1, high = -1;
            for(int num : nums){
                high = Math.max(high,num);
            }

            while(low <= high){
                int mid = low + (high-low)/2;
                if(isPossible(nums, threshold, mid)){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            return low;
        }
    }
}
