package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class NextGreateToRightCircular {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Deque<Integer> st = new ArrayDeque<>();
            for(int i = 2*n -1; i >= 0; i--){
                while(!st.isEmpty() && st.peek() <= nums[i%n]){
                    st.pop(); // Remove smaller or equal elements
                }

                if(i < n){ // Fill answers only in the first n passes
                    ans[i] = st.isEmpty() ? -1 : st.peek();
                }

                st.push(nums[i%n]); // Add current number to stack
            }

            return ans;
        }
    }
}
