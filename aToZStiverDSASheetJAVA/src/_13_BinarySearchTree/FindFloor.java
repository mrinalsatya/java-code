package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://www.geeksforgeeks.org/problems/floor-in-bst/1
public class FindFloor {
    class Solution {

        public static int floor(Node root, int x) {

            // If tree is empty, no floor exists
            if (root == null) return -1;

            int floor = -1;
            Node curr = root;

            // Traverse the BST
            while (curr != null) {

                // If current node is a valid floor candidate
                if (curr.data <= x) {
                    floor = curr.data;     // update answer
                    curr = curr.right;     // try to find a larger but valid floor
                }
                // If current node is greater than x, move left
                else {
                    curr = curr.left;
                }
            }

            return floor;
        }
    }

}
