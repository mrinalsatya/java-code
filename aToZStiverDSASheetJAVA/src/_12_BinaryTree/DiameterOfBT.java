package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/diameter-of-binary-tree/
/*
Key Interview Explanation
 - Diameter = longest path between any two nodes
 - Path may or may not pass through the root
 - At every node:
 - diameter = max(diameter, height(left) + height(right))
 - Height is computed bottom-up
 - Diameter is updated in the same DFS traversal

Complexity (Optimal) - TC: O(n) - Each node visited once
SC: O(h) - Recursion stack | Worst case: O(n) (skewed tree) | Best case: O(log n) (balanced tree)
No of nodes = diameter + 1;
 */
public class DiameterOfBT {
    class Solution {

        // Stores the maximum diameter found so far
        // Diameter = number of edges in the longest path
        int diameter = 0;

        /**
         * Helper function to compute height of the tree.
         * While computing height, it also updates the diameter.
         */
        public int height(TreeNode root) {

            // Base case: empty tree has height 0
            if (root == null) {
                return 0;
            }

            // Recursively compute height of left subtree
            int lh = height(root.left);

            // Recursively compute height of right subtree
            int rh = height(root.right);

            // Update diameter:
            // Longest path passing through current node
            // = height of left subtree + height of right subtree
            diameter = Math.max(diameter, lh + rh);

            // Return height of current node
            return 1 + Math.max(lh, rh);
        }

        /**
         * Returns the diameter of the binary tree
         */
        public int diameterOfBinaryTree(TreeNode root) {

            // Compute height and update diameter during DFS
            height(root);

            return diameter;
        }
    }

}
