package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://leetcode.com/problems/jump-game-ii/description/
/*
Greedy Intuition (Interview Explanation)
 - Think of this as BFS on array indices
 - Each jump explores a range of indices
 - From that range, we find how far we can go in one more jump
 - Expanding the range step by step guarantees minimum jumps

Complexity (Optimal) - TC: O(n) Each index is processed once | SC: O(1)
 */
public class JumpGameII {
    class Solution {
        public int jump(int[] nums) {

            int n = nums.length;

            // Number of jumps needed
            int jumps = 0;

            // l and r define the current "window" (range of indices)
            // that can be reached with the current number of jumps
            int l = 0, r = 0;

            // Continue until we can reach the last index
            while (r < n - 1) {

                int farthest = 0;

                // Explore all positions reachable in the current jump range
                // and find the farthest index we can reach in the next jump
                for (int i = l; i <= r; i++) {
                    farthest = Math.max(farthest, i + nums[i]);
                }

                // Move to the next jump range
                l = r + 1;
                r = farthest;

                // Increment jump count
                jumps++;
            }

            return jumps;
        }
    }

}
