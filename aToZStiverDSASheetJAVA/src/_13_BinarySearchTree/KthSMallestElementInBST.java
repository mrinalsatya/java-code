package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSMallestElementInBST {
    class Solution {

        int count = 0;
        int result = -1;

        public int kthSmallest(TreeNode root, int k) {
            inorder(root, k);
            return result;
        }

        private void inorder(TreeNode root, int k) {
            if (root == null) return;

            // Visit left subtree
            inorder(root.left, k);

            // Visit current node
            count++;
            if (count == k) {
                result = root.val;
                return;
            }

            // Visit right subtree
            inorder(root.right, k);
        }
    }

}
