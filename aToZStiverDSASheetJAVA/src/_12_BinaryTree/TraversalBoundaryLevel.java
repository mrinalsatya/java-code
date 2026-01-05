package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
//TC: O(n) | SC: O(n) (recursion + result)
public class TraversalBoundaryLevel {
    class Solution {

        ArrayList<Integer> res = new ArrayList<>();

        // Utility function to check if a node is a leaf
        public boolean isLeaf(Node root) {
            return root.left == null && root.right == null;
        }

        // Add left boundary (excluding root and leaf nodes)
        public void addLeftBoundary(Node root) {
            Node curr = root.left;

            while (curr != null) {
                // Add current node if it is not a leaf
                if (!isLeaf(curr)) {
                    res.add(curr.data);
                }

                // Move to the left if possible, otherwise to the right
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
        }

        // Add all leaf nodes using DFS (left to right)
        public void addLeaves(Node root) {
            if (root == null) return;

            if (isLeaf(root)) {
                res.add(root.data);
                return;
            }

            if (root.left != null) addLeaves(root.left);
            if (root.right != null) addLeaves(root.right);
        }

        // Add right boundary (excluding root and leaf nodes)
        // Added in reverse order (bottom-up)
        public void addRightBoundary(Node root) {
            Node curr = root.right;
            ArrayList<Integer> temp = new ArrayList<>();

            while (curr != null) {
                // Add current node if it is not a leaf
                if (!isLeaf(curr)) {
                    temp.add(curr.data);
                }

                // Move to the right if possible, otherwise to the left
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }

            // Add right boundary in reverse order
            for (int i = temp.size() - 1; i >= 0; i--) {
                res.add(temp.get(i));
            }
        }

        // Main function to perform boundary traversal
        ArrayList<Integer> boundaryTraversal(Node root) {

            if (root == null) {
                return res;
            }

            // Add root node if it is not a leaf
            if (!isLeaf(root)) {
                res.add(root.data);
            }

            // Add left boundary
            addLeftBoundary(root);

            // Add all leaf nodes
            addLeaves(root);

            // Add right boundary
            addRightBoundary(root);

            return res;
        }
    }

}
