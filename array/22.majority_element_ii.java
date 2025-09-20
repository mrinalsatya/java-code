class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 = Integer.MAX_VALUE, el2 = Integer.MAX_VALUE, cnt1 = 0, cnt2 = 0, n = nums.length, max = n/3;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(cnt1 ==0  && nums[i] != el2){
                cnt1++;
                el1 = nums[i];
            }else if(cnt2 == 0 && nums[i] != el1){
                cnt2++;
                el2 = nums[i];
            }else if(el1 == nums[i]){
                cnt1++;
            }else if(el2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
        }

        if (cnt1 > n / 3) ans.add(el1);
        if (cnt2 > n / 3) ans.add(el2);

        return ans;
    }
}