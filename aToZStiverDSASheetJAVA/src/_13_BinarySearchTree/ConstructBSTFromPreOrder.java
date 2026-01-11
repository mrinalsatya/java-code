package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//TC - O(n) | SC - (h)
public class ConstructBSTFromPreOrder {
    class Solution {
        int ind = 0;

        // Builds BST using preorder and an upper bound
        public TreeNode constructBST(int[] preorder, int bound) {

            // Stop if all elements are used or current value violates BST bound
            if (ind == preorder.length || preorder[ind] > bound) {
                return null;
            }

            // Create current root
            TreeNode root = new TreeNode(preorder[ind++]);

            // All values < root.val go to left subtree
            root.left = constructBST(preorder, root.val);

            // Remaining values (<= bound and > root.val) go to right subtree
            root.right = constructBST(preorder, bound);

            return root;
        }

        public TreeNode bstFromPreorder(int[] preorder) {
            return constructBST(preorder, Integer.MAX_VALUE);
        }
    }

}
