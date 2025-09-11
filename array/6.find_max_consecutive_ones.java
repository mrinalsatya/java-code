class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0;
        int currentOne = 0;
        for(int n: nums){
            if(n==1){
                currentOne++;
            }else{
                maxOne = Math.max(maxOne, currentOne);
                currentOne = 0;
            }
        }
        maxOne = Math.max(maxOne, currentOne);

        return maxOne;
    }
}