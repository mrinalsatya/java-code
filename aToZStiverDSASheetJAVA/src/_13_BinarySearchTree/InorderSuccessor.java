package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1
/*
| Metric | Value  |
| ------ | ------ |
| Time   | `O(h)` |
| Space  | `O(1)` |
*/
public class InorderSuccessor {
    class Solution {
        // Returns the inorder successor of Node x in the BST rooted at 'root'
        public int inorderSuccessor(Node root, Node x) {

            // If tree is empty, no successor exists
            if (root == null) return -1;

            int succ = -1;  // Stores the potential successor

            // Traverse the BST
            while (root != null) {

                // If current node can be a successor
                if (root.data > x.data) {
                    succ = root.data;     // update answer
                    root = root.left;     // try to find a smaller valid successor
                }
                // Otherwise, move right
                else {
                    root = root.right;
                }
            }

            return succ;
        }
    }

}
