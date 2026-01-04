package aToZStiverDSASheetJAVA.src._11_Greedy;
/*
Key Interview Explanation - Uses a greedy strategy
 - At every index, track the maximum distance reachable
 - If at any point the current index is not reachable, return false
 - Otherwise, keep extending the reach
Complexity (Optimal) - TC: O(n) | SC: O(1)
 */
public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {

            int n = nums.length;

            // maxReachIndex keeps track of the farthest index
            // we can reach so far
            int maxReachIndex = 0;

            // Traverse each index in the array
            for (int i = 0; i < n; i++) {

                // If current index is beyond the farthest reachable index,
                // then we cannot reach this position
                if (i > maxReachIndex) {
                    return false;
                }

                // Update the farthest reachable index
                // from the current position
                maxReachIndex = Math.max(maxReachIndex, i + nums[i]);

                // If we can already reach or cross the last index,
                // no need to continue
                if (maxReachIndex >= n - 1) {
                    return true;
                }
            }

            // If loop completes, the last index is reachable
            return true;
        }
    }

}
