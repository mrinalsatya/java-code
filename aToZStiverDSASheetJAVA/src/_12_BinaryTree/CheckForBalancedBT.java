package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/balanced-binary-tree/description/
/*
Complexity (Optimal)
Time Complexity: O(n)
 - Each node visited once
Space Complexity: O(h)
 - Recursive call stack
 - h = height of tree
 - Worst case: O(n) (skewed tree)
 - Best case: O(log n) (balanced tree)
 */
public class CheckForBalancedBT {
    class Solution {

        /**
         * Helper function to compute the height of the tree.
         * Returns:
         *  - height of subtree if balanced
         *  - -1 if subtree is unbalanced
         */
        public int checkHeight(TreeNode root) {

            // Base case: empty tree has height 0
            if (root == null) {
                return 0;
            }

            // Recursively compute height of left subtree
            int leftHeight = checkHeight(root.left);

            // Recursively compute height of right subtree
            int rightHeight = checkHeight(root.right);

            // If either subtree is already unbalanced,
            // propagate the failure upward
            if (leftHeight == -1 || rightHeight == -1) {
                return -1;
            }

            // If height difference exceeds 1,
            // current subtree is unbalanced
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            // Return height of current subtree
            return 1 + Math.max(leftHeight, rightHeight);
        }

        /**
         * Checks whether the binary tree is height-balanced
         */
        public boolean isBalanced(TreeNode root) {

            // Tree is balanced if checkHeight does not return -1
            return checkHeight(root) != -1;
        }
    }

}
