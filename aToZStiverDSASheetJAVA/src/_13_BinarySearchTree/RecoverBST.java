package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {
    class Solution {

        // Pointers to track misplaced nodes
        TreeNode first, middle, last, prev;

        /**
         * Inorder traversal of BST.
         * Inorder of a valid BST should be in strictly increasing order.
         * Any violation (current < previous) indicates swapped nodes.
         */
        public void inorder(TreeNode root) {
            if (root == null) return;

            // Visit left subtree
            inorder(root.left);

            // Detect violation of BST property
            // If previous node exists and current value is smaller,
            // then we have found a misplaced pair.
            if (prev != null && root.val < prev.val) {

                // First violation:
                // mark 'first' as previous and 'middle' as current
                if (first == null) {
                    first = prev;
                    middle = root;
                }
                // Second violation (only happens when nodes are non-adjacent):
                // mark 'last' as current
                else {
                    last = root;
                }
            }

            // Update previous node
            prev = root;

            // Visit right subtree
            inorder(root.right);
        }

        /**
         * Recovers the BST by swapping back the misplaced nodes.
         */
        public void recoverTree(TreeNode root) {

            // Initialize pointers
            first = last = middle = null;
            // Use a dummy node with very small value for initial comparison
            prev = new TreeNode(Integer.MIN_VALUE);

            // Perform inorder traversal to find misplaced nodes
            inorder(root);

            // Case 1: Non-adjacent nodes were swapped
            // Example: 1 4 3 2 5  -> violations at (4,3) and (3,2)
            if (first != null && last != null) {
                int temp = first.val;
                first.val = last.val;
                last.val = temp;
            }
            // Case 2: Adjacent nodes were swapped
            // Example: 1 3 2 4 5 -> only one violation (3,2)
            else if (first != null && middle != null) {
                int temp = first.val;
                first.val = middle.val;
                middle.val = temp;
            }
        }
    }

}
