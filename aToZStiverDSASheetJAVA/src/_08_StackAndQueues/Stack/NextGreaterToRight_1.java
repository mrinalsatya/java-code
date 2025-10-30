package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class NextGreaterToRight_1 {
    class Solution {
        public List<Integer> nextGreaterEle(int[] nums){
            int n = nums.length;
            List<Integer> ans = new ArrayList<>();
            Deque<Integer> st = new ArrayDeque<>();

            for(int i = n-1; i>=0; i--){
                while(!st.isEmpty() && st.peek() < nums[i]) st.pop();

                if(st.isEmpty()){
                    ans.add(-1);
                }else{
                    ans.add(st.peek());
                }

                st.push(nums[i]);
            }

            Collections.reverse(ans);
            return ans;
        }
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            List<Integer> ngr = nextGreaterEle(nums2);

            Map<Integer, Integer> mp = new HashMap<>();

            for(int i=0; i<nums2.length; i++){
                mp.put(nums2[i], ngr.get(i));
            }

            int[] ans = new int[nums1.length];

            for(int i= 0; i< nums1.length; i++){
                ans[i] = mp.get(nums1[i]);
            }

            return ans;
        }
    }
}
