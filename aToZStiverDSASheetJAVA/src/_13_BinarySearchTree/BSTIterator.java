package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/binary-search-tree-iterator/
/*
How It Works
 - The stack always maintains the path to the next smallest node
 - pushAllToLeft(root) pushes:
 - root → root.left → root.left.left → ...
 - next():
  - Pops the top (current smallest)
  - If that node has a right child, push all its left descendants
This simulates inorder traversal iteratively.
 */
public class BSTIterator {
    class BSTIterator {

        Stack<TreeNode> st;

        // Push all left nodes from the given root
        // This ensures the top of stack is always the next smallest element
        public void pushAllToLeft(TreeNode root) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
        }

        // Constructor initializes the iterator
        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            pushAllToLeft(root);
        }

        // Returns the next smallest element
        public int next() {
            TreeNode top = st.pop();

            // If the node has a right subtree,
            // push all its left children
            if (top.right != null) {
                pushAllToLeft(top.right);
            }

            return top.val;
        }

        // Checks if more elements exist
        public boolean hasNext() {
            return !st.isEmpty();
        }
    }

}
