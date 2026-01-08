package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeIntoLinkedList {
    class Solution {

        // Keeps track of the previously processed node
        // This will become the "next" node in the flattened list
        TreeNode prevNode = null;

        public void flatten(TreeNode root) {

            // Base case
            if (root == null) return;

            // Process right subtree first
            flatten(root.right);

            // Then process left subtree
            flatten(root.left);

            // Rewire pointers
            root.right = prevNode; // current node points to previously processed node
            root.left = null;      // left pointer must be null in linked list

            // Update prevNode to current node
            prevNode = root;
        }
    }
}
