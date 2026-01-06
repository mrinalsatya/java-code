package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/binary-tree-paths/description/
/*
Complexity

Time Complexity: O(n)

Every node is visited once

Space Complexity: O(h)

Recursion stack + path storage

h = height of tree
 */
public class PrintPaths {
    class Solution {

        // Stores all root-to-leaf paths
        List<String> ans = new ArrayList<>();

        /**
         * DFS helper to build paths from root to leaf
         */
        public void findPath(TreeNode root, StringBuilder s) {

            // Base case: null node
            if (root == null) {
                return;
            }

            // Store current length to backtrack later
            int length = s.length();

            // Append current node value
            s.append(root.val);

            // If leaf node, add path to result
            if (root.left == null && root.right == null) {
                ans.add(s.toString());
            } else {
                // Not a leaf, continue path with separator
                s.append("->");

                // Explore left and right subtrees
                findPath(root.left, s);
                findPath(root.right, s);
            }

            // Backtrack to previous state
            s.setLength(length);
        }

        public List<String> binaryTreePaths(TreeNode root) {

            // Edge case: empty tree
            if (root == null) return ans;

            // Use StringBuilder for efficient string manipulation
            StringBuilder s = new StringBuilder();

            // Start DFS from root
            findPath(root, s);

            return ans;
        }
    }

}
