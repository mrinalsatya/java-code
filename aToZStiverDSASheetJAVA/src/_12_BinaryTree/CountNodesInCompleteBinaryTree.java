package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/count-complete-tree-nodes/
/*
Final Complexity
 - Time Complexity: O((log n)^2)
 - Space Complexity: O(log n) (recursion stack)
 ✔ Much better than brute-force O(n)
 */
public class CountNodesInCompleteBinaryTree {
    class Solution {

        public int countNodes(TreeNode root) {

            // Base case: empty tree
            if (root == null) {
                return 0;
            }

            // Compute height of leftmost path
            int lh = 1;
            TreeNode leftPtr = root;
            while (leftPtr.left != null) {
                leftPtr = leftPtr.left;
                lh++;
            }

            // Compute height of rightmost path
            int rh = 1;
            TreeNode rightPtr = root;
            while (rightPtr.right != null) {
                rightPtr = rightPtr.right;
                rh++;
            }

            // If heights are equal, tree is a perfect binary tree
            if (lh == rh) {
                // Number of nodes in a perfect binary tree = 2^h - 1
                return (int) Math.pow(2, lh) - 1;
            }

            // Otherwise, recurse on left and right subtrees
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

}
