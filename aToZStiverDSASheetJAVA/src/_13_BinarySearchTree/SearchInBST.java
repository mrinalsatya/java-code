package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInBST {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {

            // Start traversal from the root
            TreeNode curr = root;

            // Traverse until we find the value or reach null
            while (curr != null) {

                // If current node's value matches, return this node
                if (curr.val == val) {
                    return curr;
                }

                // If target value is smaller, go to left subtree
                else if (val < curr.val) {
                    curr = curr.left;
                }

                // If target value is larger, go to right subtree
                else {
                    curr = curr.right;
                }
            }

            // Value not found in BST
            return null;
        }
    }

}
