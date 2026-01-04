package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class TraversalLevelOrder {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            // Result list to store nodes level by level
            List<List<Integer>> ans = new ArrayList<>();

            // Queue for Breadth-First Search (BFS)
            Queue<TreeNode> q = new LinkedList<>();

            // If tree is empty, return empty list
            if (root == null) {
                return ans;
            }

            // Start BFS from the root node
            q.offer(root);

            // Continue until all nodes are processed
            while (!q.isEmpty()) {

                // Number of nodes at the current level
                int size = q.size();

                // List to store current level values
                List<Integer> temp = new ArrayList<>();

                // Process all nodes of the current level
                while (size > 0) {

                    // Remove node from queue
                    TreeNode curr = q.poll();

                    // Add node value to current level list
                    temp.add(curr.val);

                    // Add left child to queue if it exists
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }

                    // Add right child to queue if it exists
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }

                    size--;
                }

                // Add the current level list to result
                ans.add(temp);
            }

            return ans;
        }
    }

}
