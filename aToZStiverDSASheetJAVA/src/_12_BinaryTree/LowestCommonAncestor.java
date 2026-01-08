package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/*
Key Idea (Interview Explanation)
 - Traverse the tree bottom-up
 - If the current node is p or q, return it
 - If:
   - One target is found in left subtree
   - The other is found in right subtree
   → current node is the LCA
 - If both are found in the same subtree, propagate that result upward
TC: O(n) - Every node visited once
SC: O(h) - Recursion stack | Worst case O(n) (skewed tree) | Best case O(log n) (balanced tree)
 */
public class LowestCommonAncestor {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // Base case:
            // If root is null, or root is one of p or q,
            // then root itself can be the LCA
            if (root == null || root == p || root == q) {
                return root;
            }

            // Recur for left subtree
            TreeNode left = lowestCommonAncestor(root.left, p, q);

            // Recur for right subtree
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // If one node is found in left subtree
            // and the other in right subtree, current root is LCA
            if (left != null && right != null) {
                return root;
            }

            // Otherwise, return the non-null subtree result
            return (left != null) ? left : right;
        }
    }

}
