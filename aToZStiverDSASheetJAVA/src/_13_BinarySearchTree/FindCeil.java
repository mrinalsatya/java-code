package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
public class FindCeil {
    class Solution {

        int findCeil(Node root, int x) {

            // If tree is empty, no ceil exists
            if (root == null) return -1;

            Node curr = root;
            int ceil = -1;

            // Traverse the BST
            while (curr != null) {

                // If current node can be a ceil
                if (curr.data >= x) {
                    ceil = curr.data;     // update potential answer
                    curr = curr.left;     // try to find smaller ceil
                }
                // If current node is smaller than x, go right
                else {
                    curr = curr.right;
                }
            }

            return ceil;
        }
    }

}
