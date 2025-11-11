package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;

public class ReArrangeArrayElementsBySign {
    class Solution {
        public int[] rearrangeArray(int[] nums) {
            int i = 0, j = 0, k = 0, n = nums.length;
            int[] ans = new int[n];

            while(i < n || j < n){
                while(i < n && nums[i] <= 0) i++;
                if(i < n){
                    ans[k++] = nums[i];
                    nums[i] = 0;
                }
                while(j < n && nums[j] >= 0) j++;
                if(j < n){
                    ans[k++] = nums[j];
                    nums[j] = 0;
                }
            }

            return ans;
        }

    // faster approach, skip 2 index
        public int[] rearrangeArray2(int[] nums) {
            int n=nums.length;
            int i=0,j=1;
            int ans[] = new int[n];
            for(int k=0;k<n;k++){
                if(nums[k]>0){
                    ans[i]=nums[k];
                    i+=2;
                }
                else
                {
                    ans[j]=nums[k];
                    j+=2;
                }
            }
            return ans;
        }
    }
}
