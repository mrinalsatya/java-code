package aToZStiverDSASheetJAVA.src._03_Arrays.Hard;
//https://leetcode.com/problems/3sum/
public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);
            for(int i = 0; i < n-2; i++){
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int l = i+1, r = n-1;
                while(l<r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0){
                        ans.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[l],nums[r])));
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(r > l && nums[r] == nums[r+1]) r--;

                    }
                    else if(sum > 0){
                        r--;
                    }
                    else{
                        l++;
                    }
                }
            }

            return ans;
        }
    }
}
