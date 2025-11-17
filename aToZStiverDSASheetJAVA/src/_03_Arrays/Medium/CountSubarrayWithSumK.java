package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;
//https://leetcode.com/problems/subarray-sum-equals-k/
public class CountSubarrayWithSumK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length, prefixSum = 0, count = 0;
            Map<Integer, Integer> sum = new HashMap<>();
            sum.put(0,1);
            for(int i = 0; i< n; i++){
                prefixSum += nums[i];
                int diff = prefixSum - k;
                if(sum.containsKey(diff)){
                    count += sum.get(diff);
                }
                sum.put(prefixSum, sum.getOrDefault(prefixSum, 0) + 1);
            }

            return count;
        }
    }
}
