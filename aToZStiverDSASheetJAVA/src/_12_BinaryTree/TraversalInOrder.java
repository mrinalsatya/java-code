package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// TC - O(n) | SC - O(n)
public class TraversalInOrder {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            // List to store inorder traversal result
            List<Integer> ans = new ArrayList<>();

            // Stack to simulate recursion
            Stack<TreeNode> st = new Stack<>();

            // Pointer to traverse the tree
            TreeNode curr = root;

            // Continue while there are nodes to process
            // either in the tree or in the stack
            while (curr != null || !st.isEmpty()) {

                // Step 1: Reach the leftmost node of the current subtree
                while (curr != null) {
                    st.push(curr);
                    curr = curr.left;
                }

                // Step 2: Process the node at the top of the stack
                TreeNode temp = st.pop();
                ans.add(temp.val);  // Visit node (Inorder: Left → Root → Right)

                // Step 3: Move to the right subtree
                curr = temp.right;
            }

            return ans;
        }
    }

}
