package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;

public class DeleteNodeInBST {
    class Solution {

        // Find the rightmost node in a subtree (maximum in that subtree)
        public TreeNode findLastRight(TreeNode root) {
            if (root.right == null) return root;
            return findLastRight(root.right);
        }

        /**
         * Deletes the given root node and returns the new subtree root.
         */
        public TreeNode helper(TreeNode root) {

            // Case 1: No left child → replace with right subtree
            if (root.left == null) return root.right;

            // Case 2: No right child → replace with left subtree
            if (root.right == null) return root.left;

            // Case 3: Both children exist
            // Attach right subtree to the rightmost node of left subtree
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;

            // Return left child as new root of this subtree
            return root.left;
        }

        public TreeNode deleteNode(TreeNode root, int key) {

            if (root == null) return null;

            // If the root itself is the node to delete
            if (root.val == key) {
                return helper(root);
            }

            TreeNode curr = root;

            // Traverse the BST to find the node
            while (curr != null) {
                if (key < curr.val) {
                    if (curr.left != null && curr.left.val == key) {
                        curr.left = helper(curr.left);
                        break;
                    }
                    curr = curr.left;
                } else {
                    if (curr.right != null && curr.right.val == key) {
                        curr.right = helper(curr.right);
                        break;
                    }
                    curr = curr.right;
                }
            }

            return root;
        }
    }
}
