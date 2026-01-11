package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/recover-binary-search-tree/
public class LargestBSTinBT {
    // Helper class to store information about each subtree
    class NodeInfo {
        int sum;      // Sum of all nodes in this subtree
        int size;     // Number of nodes in this subtree
        int min;      // Minimum value in this subtree
        int max;      // Maximum value in this subtree
        boolean isBST; // Whether this subtree is a valid BST

        NodeInfo(int sum, int size, int min, int max, boolean isBST) {
            this.sum = sum;
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    class Solution {

        int maxSum = 0;   // Stores the maximum sum of any BST found so far

        /**
         * Postorder DFS that returns information about the subtree rooted at 'root'.
         * We use postorder because we need left and right subtree info
         * before deciding for the current node.
         */
        public NodeInfo solve(TreeNode root) {

            // Base case: empty subtree is a valid BST with sum = 0
            if (root == null) {
                return new NodeInfo(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            }

            // Get information from left and right subtrees
            NodeInfo left = solve(root.left);
            NodeInfo right = solve(root.right);

            // Check if current subtree forms a BST
            // Conditions:
            // 1. Left and right subtrees are BSTs
            // 2. Max of left < root.val < Min of right
            if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {

                // Current subtree is a valid BST
                int currSum = left.sum + root.val + right.sum;
                int currSize = 1 + left.size + right.size;

                // Update global maximum sum
                maxSum = Math.max(maxSum, currSum);

                return new NodeInfo(
                        currSum,
                        currSize,
                        Math.min(root.val, left.min),   // new min
                        Math.max(root.val, right.max),  // new max
                        true
                );
            }
            else {
                // Not a BST, return invalid NodeInfo
                // sum is set to 0 since this subtree can't contribute
                return new NodeInfo(
                        0,
                        Math.max(left.size, right.size),
                        0,
                        0,
                        false
                );
            }
        }

        /**
         * Main function to return the maximum sum of any BST subtree.
         */
        public int maxSumBST(TreeNode root) {
            solve(root);
            return maxSum;
        }
    }

}
