class Solution {
    public int missingNumber(int[] nums) {
        int m = nums.length;
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        int sumN = m * (m+1)/2;

        return sumN - sum;
    }
}