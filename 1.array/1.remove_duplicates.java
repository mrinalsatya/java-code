class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 0, j =1;
        int n = nums.length;
        while(i< n-1 && j < n){
            while(j < n && nums[i] != nums[j])
            {
                i++;
                nums[i] = nums[j++];
            }
            j++;
        }
        return i+1;
    }
}