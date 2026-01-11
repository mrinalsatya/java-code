package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
    class Solution {

        /**
         * Validates BST by ensuring every node lies in a valid range.
         *
         * minValue -> lower bound (exclusive)
         * maxValue -> upper bound (exclusive)
         */
        public boolean validateBST(TreeNode root, long minValue, long maxValue) {

            // Base case: empty subtree is valid
            if (root == null) {
                return true;
            }

            // Current node must lie strictly between min and max
            if (root.val <= minValue || root.val >= maxValue) {
                return false;
            }

            // Left subtree: values must be < root.val
            // Right subtree: values must be > root.val
            return validateBST(root.left, minValue, root.val)
                    && validateBST(root.right, root.val, maxValue);
        }

        public boolean isValidBST(TreeNode root) {

            // An empty tree is a valid BST
            if (root == null) return true;

            // Use long bounds to avoid integer overflow
            return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }

}
