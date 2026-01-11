package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertNodeInBSTIterative {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {

            if (root == null) return new TreeNode(val);

            TreeNode curr = root;

            while (true) {
                if (val > curr.val) {
                    if (curr.right == null) {
                        curr.right = new TreeNode(val);
                        break;
                    }
                    curr = curr.right;
                } else {
                    if (curr.left == null) {
                        curr.left = new TreeNode(val);
                        break;
                    }
                    curr = curr.left;
                }
            }

            return root;
        }
    }

}
