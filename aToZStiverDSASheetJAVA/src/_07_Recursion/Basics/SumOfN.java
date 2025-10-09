package aToZStiverDSASheetJAVA.src._07_Recursion.Basics;
//https://leetcode.com/problems/missing-number/
public class SumOfN {
    public static int sumOfN(int num){
        if(num <= 0)
            return num;
        int sum = num + sumOfN(num-1);
        return sum;
    }
    public int missingNumber(int[] nums) {
        int m = nums.length;
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        int sumN = sumOfN(m);

        return sumN - sum;
    }
}
