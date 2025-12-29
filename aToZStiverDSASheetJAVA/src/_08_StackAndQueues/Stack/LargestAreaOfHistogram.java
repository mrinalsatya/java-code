package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestAreaOfHistogram {
    class Solution {

        /**
         * Finds index of Nearest Smaller Element to the Left (NSL) for each bar.
         * If no smaller element exists on the left, store -1.
         */
        public List<Integer> findNearestSmallerToLeft(int[] nums) {

            List<Integer> ans = new ArrayList<>();
            Stack<Integer> st = new Stack<>(); // stores indices

            // Traverse from left to right
            for (int i = 0; i < nums.length; i++) {

                // Remove elements that are >= current bar
                // because they cannot be NSL
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }

                // If stack is empty, no smaller element on left
                if (st.isEmpty()) {
                    ans.add(-1);
                } else {
                    ans.add(st.peek());
                }

                // Push current index
                st.push(i);
            }

            return ans;
        }

        /**
         * Finds index of Nearest Smaller Element to the Right (NSR) for each bar.
         * If no smaller element exists on the right, store nums.length.
         */
        public List<Integer> findNearestSmallerToRight(int[] nums) {

            List<Integer> ans = new ArrayList<>();
            Stack<Integer> st = new Stack<>(); // stores indices

            // Traverse from right to left
            for (int i = nums.length - 1; i >= 0; i--) {

                // Remove elements that are >= current bar
                // because they cannot be NSR
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }

                // If stack is empty, no smaller element on right
                if (st.isEmpty()) {
                    ans.add(nums.length); // imaginary boundary
                } else {
                    ans.add(st.peek());
                }

                // Push current index
                st.push(i);
            }

            // Reverse because we filled from right to left
            Collections.reverse(ans);
            return ans;
        }

        /**
         * Calculates the largest rectangle area in the histogram.
         */
        public int largestRectangleArea(int[] heights) {

            // Get nearest smaller indices on both sides
            List<Integer> nsl = findNearestSmallerToLeft(heights);
            List<Integer> nsr = findNearestSmallerToRight(heights);

            int ans = 0;

            // Calculate maximum area considering each bar as the smallest bar
            for (int i = 0; i < heights.length; i++) {

                // Width between smaller bars on both sides
                int width = nsr.get(i) - nsl.get(i) - 1;

                // Area = height * width
                ans = Math.max(ans, width * heights[i]);
            }

            return ans;
        }
    }

}
