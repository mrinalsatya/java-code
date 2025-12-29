package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;
//https://leetcode.com/problems/maximal-rectangle/
public class LargestAreaIn2DMatrix {
    class Solution {

        /**
         * Finds Nearest Smaller Element to the Right (NSR) index for each bar.
         * If no smaller element exists on the right, we use nums.length
         * as a virtual boundary.
         */
        public List<Integer> findNSR(int[] nums) {

            List<Integer> ans = new ArrayList<>();
            Stack<Integer> st = new Stack<>(); // stores indices

            // Traverse from right to left
            for (int i = nums.length - 1; i >= 0; i--) {

                // Remove elements that are >= current bar
                // because they cannot be NSR
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }

                // If stack is not empty, top is the NSR
                // else, no smaller element exists on the right
                if (!st.isEmpty()) {
                    ans.add(st.peek());
                } else {
                    ans.add(nums.length); // virtual boundary
                }

                // Push current index
                st.push(i);
            }

            // Reverse because traversal was from right to left
            Collections.reverse(ans);
            return ans;
        }

        /**
         * Finds Nearest Smaller Element to the Left (NSL) index for each bar.
         * If no smaller element exists on the left, we use -1
         * as a virtual boundary.
         */
        public List<Integer> findNSL(int[] nums) {

            List<Integer> ans = new ArrayList<>();
            Stack<Integer> st = new Stack<>(); // stores indices

            // Traverse from left to right
            for (int i = 0; i < nums.length; i++) {

                // Remove elements that are >= current bar
                // to maintain monotonic increasing stack
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }

                // If stack is not empty, top is the NSL
                // else, no smaller element exists on the left
                if (!st.isEmpty()) {
                    ans.add(st.peek());
                } else {
                    ans.add(-1); // virtual boundary
                }

                // Push current index
                st.push(i);
            }

            return ans;
        }

        /**
         * Computes the maximum rectangular area in a histogram.
         */
        public int maximumAreaHistogram(int[] nums) {

            // Get nearest smaller indices on both sides
            List<Integer> nsr = findNSR(nums);
            List<Integer> nsl = findNSL(nums);

            int area = 0;

            // Calculate area considering each bar as the minimum height
            for (int i = 0; i < nums.length; i++) {

                // Width = distance between smaller bars on both sides
                int width = nsr.get(i) - nsl.get(i) - 1;

                // Area = height * width
                area = Math.max(area, width * nums[i]);
            }

            return area;
        }

        /**
         * Finds the maximum rectangle of 1's in a binary matrix.
         */
        public int maximalRectangle(char[][] matrix) {

            int ans = 0;

            // heights[] represents histogram heights for each column
            int[] heights = new int[matrix[0].length];
            Arrays.fill(heights, 0);

            // Build histogram row by row
            for (int i = 0; i < matrix.length; i++) {

                for (int j = 0; j < matrix[0].length; j++) {

                    // If cell is '0', reset height
                    if (matrix[i][j] == '0') {
                        heights[j] = 0;
                    } else {
                        // If cell is '1', increase height
                        heights[j] += 1;
                    }
                }

                // Compute max area for current histogram
                ans = Math.max(ans, maximumAreaHistogram(heights));
            }

            return ans;
        }
    }

}
