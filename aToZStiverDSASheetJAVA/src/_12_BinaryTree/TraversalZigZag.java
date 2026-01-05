package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
/*
Complexity (Optimal) - TC: O(n) Each node visited once | SC: O(n) Queue + result list
 */
public class TraversalZigZag {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            // Result list to store zigzag level order traversal
            List<List<Integer>> ans = new ArrayList<>();

            // Queue for level order traversal (BFS)
            Queue<TreeNode> q = new LinkedList<>();

            // If tree is empty, return empty result
            if (root == null) {
                return ans;
            }

            // Add root node to the queue
            q.offer(root);

            // Flag to control direction of traversal
            // false -> left to right
            // true  -> right to left
            boolean flag = false;

            // Perform BFS
            while (!q.isEmpty()) {

                // Number of nodes at the current level
                int size = q.size();

                // List to store current level values
                List<Integer> list = new ArrayList<>();

                // Process all nodes of the current level
                while (size > 0) {

                    // Remove node from queue
                    TreeNode temp = q.poll();

                    // Add left child first
                    if (temp.left != null) {
                        q.offer(temp.left);
                    }

                    // Add right child
                    if (temp.right != null) {
                        q.offer(temp.right);
                    }

                    // Add current node value
                    list.add(temp.val);
                    size--;
                }

                // If flag is true, reverse the level to get zigzag order
                if (flag) {
                    Collections.reverse(list);
                }

                // Add the processed level to the result
                ans.add(list);

                // Toggle direction for next level
                flag = !flag;
            }

            return ans;
        }
    }

}
