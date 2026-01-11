package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertNodeInBSTRecursive {
    class Solution {

        public TreeNode insertIntoBST(TreeNode root, int val) {

            // Base case: empty position found, insert new node here
            if (root == null) {
                return new TreeNode(val);
            }

            // If value is greater than current node, insert in right subtree
            if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            }
            // If value is smaller (or equal), insert in left subtree
            else {
                root.left = insertIntoBST(root.left, val);
            }

            // Return the unchanged root pointer
            return root;
        }
    }

}
