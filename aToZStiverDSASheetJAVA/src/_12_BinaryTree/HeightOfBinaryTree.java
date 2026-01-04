package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class HeightOfBinaryTree {
    class Solution {
        public int maxDepth(TreeNode root) {

            // Base case:
            // If the tree (or subtree) is empty, depth is 0
            if (root == null) {
                return 0;
            }

            // Recursively calculate the depth of left subtree
            int left = 1 + maxDepth(root.left);

            // Recursively calculate the depth of right subtree
            int right = 1 + maxDepth(root.right);

            // Depth of current node is the maximum of
            // left and right subtree depths
            return Math.max(left, right);
        }
    }

}
