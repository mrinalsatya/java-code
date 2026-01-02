package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;
//https://leetcode.com/problems/sliding-window-maximum/
/*
Time Complexity - O(n)
-Each index is: Added once, Removed once
-No nested iteration over the same elements

Space Complexity - O(k)
- Deque stores at most k elements (window size)
- Result array not counted as auxiliary space

One-Line Interview Answer - “We maintain a monotonic decreasing deque to keep track of maximum elements in each sliding window, achieving O(n) time and O(k) space complexity.”
 */
public class SlidingWindowMaximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            int n = nums.length;

            // Result array size = number of windows
            int[] ans = new int[n - k + 1];
            int ind = 0;

            // Deque stores indices of elements
            // Maintains a decreasing order of values
            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {

                // 1️⃣ Remove indices that are out of the current window
                // Window range is [i - k + 1, i]
                if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    dq.pollFirst();
                }

                // 2️⃣ Maintain decreasing order in deque
                // Remove all elements smaller than or equal to current element
                while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                    dq.pollLast();
                }

                // 3️⃣ Add current index to deque
                dq.offerLast(i);

                // 4️⃣ Store the maximum once the first window is complete
                if (i >= k - 1) {
                    ans[ind++] = nums[dq.peekFirst()];
                }
            }

            return ans;
        }
    }

}
