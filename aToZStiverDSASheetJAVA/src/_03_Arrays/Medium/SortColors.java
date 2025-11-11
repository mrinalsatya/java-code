package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;

public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            int low = 0, mid = 0, high = nums.length -1;
            while(mid<=high){
                if(nums[mid] == 0){
                    swapNums(nums, low, mid);
                    low++;
                    mid++;
                }
                else if(nums[mid] == 2){
                    swapNums(nums, mid, high);
                    high--;
                }
                else{
                    mid++;
                }
            }

        }

        public void swapNums(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
