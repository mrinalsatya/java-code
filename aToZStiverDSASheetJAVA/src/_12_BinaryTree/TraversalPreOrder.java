package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/binary-tree-preorder-traversal/
// TC - O(n) | SC - O(n)
public class TraversalPreOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            // List to store preorder traversal result
            List<Integer> ans = new ArrayList<>();

            // Stack to simulate recursion
            Stack<TreeNode> st = new Stack<>();

            // If tree is empty, return empty list
            if (root == null) {
                return ans;
            }

            // Start by pushing the root node
            st.push(root);

            // Process nodes until stack is empty
            while (!st.isEmpty()) {

                // Pop the top node
                TreeNode curr = st.pop();

                // Visit the node (Preorder: Root -> Left -> Right)
                ans.add(curr.val);

                // Push right child first
                // so that left child is processed first
                if (curr.right != null) {
                    st.push(curr.right);
                }

                // Push left child
                if (curr.left != null) {
                    st.push(curr.left);
                }
            }

            return ans;
        }
    }

}
