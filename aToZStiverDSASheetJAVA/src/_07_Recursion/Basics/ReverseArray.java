package aToZStiverDSASheetJAVA.src._07_Recursion.Basics;

import java.util.Arrays;

public class ReverseArray {
    public static void reverseArray(int[] nums, int l, int r){
        if(l > r)
            return;
        reverseArray(nums, l+1, r-1);
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(nums));

        reverseArray(nums, 0 , nums.length -1);
        System.out.println(Arrays.toString(nums));
    }
}
