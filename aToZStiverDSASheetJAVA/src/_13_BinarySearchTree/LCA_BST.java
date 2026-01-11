package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/*
In a BST:
 - All values in the left subtree are < root.val
 - All values in the right subtree are > root.val
So: - If both p and q are smaller than root, LCA lies in the left subtree
    - If both are greater, LCA lies in the right subtree
    - Otherwise, root is where they split → this is the LCA
 */
public class LCA_BST {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // Base case: if root is null or equals p or q
            if (root == null || root == p || root == q) {
                return root;
            }

            // If both p and q lie in the right subtree
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }

            // If both p and q lie in the left subtree
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }

            // Otherwise, root is the split point -> LCA
            return root;
        }
    }

}
