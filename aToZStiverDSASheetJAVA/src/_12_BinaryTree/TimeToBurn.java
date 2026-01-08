package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
public class TimeToBurn {
    class Solution {

        // Stores parent of each node
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        /**
         * Finds:
         * 1) The target node where infection starts
         * 2) Parent mapping for each node
         */
        public TreeNode getTargetAndParents(TreeNode root, int start) {

            TreeNode target = null;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode curr = q.poll();

                // Identify the starting node
                if (curr.val == start) {
                    target = curr;
                }

                // Map parent pointers
                if (curr.left != null) {
                    parents.put(curr.left, curr);
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    parents.put(curr.right, curr);
                    q.offer(curr.right);
                }
            }

            return target;
        }

        public int amountOfTime(TreeNode root, int start) {

            // Step 1: find target node and build parent mapping
            TreeNode target = getTargetAndParents(root, start);

            // Track infected (visited) nodes
            Map<TreeNode, Bo

        }
