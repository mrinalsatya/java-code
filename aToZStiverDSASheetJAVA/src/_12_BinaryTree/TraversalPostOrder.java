package aToZStiverDSASheetJAVA.src._12_BinaryTree;

public class TraversalPostOrder {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {

            // List to store postorder traversal result
            List<Integer> ans = new ArrayList<>();

            // Stack to simulate recursion
            Stack<TreeNode> st = new Stack<>();

            // If tree is empty, return empty list
            if (root == null) {
                return ans;
            }

            // Push root node into stack
            st.push(root);

            /**
             * We follow a modified preorder traversal:
             * Root → Right → Left
             * Then reverse the result to get:
             * Left → Right → Root (Postorder)
             */
            while (!st.isEmpty()) {

                // Pop current node
                TreeNode curr = st.pop();

                // Add node value to result list
                ans.add(curr.val);

                // Push left child first
                // so that right child is processed before left
                if (curr.left != null) {
                    st.push(curr.left);
                }

                // Push right child
                if (curr.right != null) {
                    st.push(curr.right);
                }
            }

            // Reverse the traversal to obtain postorder
            Collections.reverse(ans);

            return ans;
        }
    }

}
