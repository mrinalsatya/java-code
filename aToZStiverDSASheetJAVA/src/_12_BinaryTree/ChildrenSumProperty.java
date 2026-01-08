package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://www.geeksforgeeks.org/problems/children-sum-parent/1
//TC - O(n) | SC - O(h) (recursive stack)
public class ChildrenSumProperty {
    class Solution {

        public boolean isSumProperty(Node root) {

            // Null or leaf node always satisfies property
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }

            int leftVal = (root.left != null) ? root.left.data : 0;
            int rightVal = (root.right != null) ? root.right.data : 0;

            // Check current node
            if (root.data != leftVal + rightVal) {
                return false;
            }

            // Recur for left and right subtrees
            return isSumProperty(root.left) && isSumProperty(root.right);
        }
    }

}
