package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
//Complexity (Optimal) - TC: O(n) | SC: O(h) (recursion stack)
//“At each node, we compute the maximum gain from left and right subtrees,
//update the global path sum allowing branching, and return a non-branching path upward.”
public class MaximumPathSum {
    class Solution {

        // Stores the maximum path sum found so far
        int maxSum = Integer.MIN_VALUE;

        /**
         * Helper function that returns the maximum path sum
         * starting from the current node and going UPWARD.
         */
        public int maxGain(TreeNode root) {

            // Base case: null node contributes 0
            if (root == null) {
                return 0;
            }

            // Recursively get max gain from left and right subtrees
            // Ignore negative contributions
            int leftGain = Math.max(0, maxGain(root.left));
            int rightGain = Math.max(0, maxGain(root.right));

            // Path sum including current node as highest point (can branch)
            int currentPathSum = leftGain + rightGain + root.val;

            // Update global maximum path sum
            maxSum = Math.max(maxSum, currentPathSum);

            // Return max gain if continuing path upwards (NO branching)
            return root.val + Math.max(leftGain, rightGain);
        }

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }
    }

}
