package aToZStiverDSASheetJAVA.src._13_BinarySearchTree;
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSum {
    class Solution {

        // Stack for inorder traversal (smallest first)
        Stack<TreeNode> nextSt = new Stack<>();

        // Stack for reverse inorder traversal (largest first)
        Stack<TreeNode> prevSt = new Stack<>();

        // Push all right nodes for reverse inorder
        public void pushAllToRight(TreeNode root){
            while(root != null){
                prevSt.push(root);
                root = root.right;
            }
        }

        // Push all left nodes for inorder
        public void pushAllToLeft(TreeNode root){
            while(root != null){
                nextSt.push(root);
                root = root.left;
            }
        }

        // Get next smallest value
        public int getNext(){
            TreeNode curr = nextSt.pop();
            if(curr.right != null){
                pushAllToLeft(curr.right);
            }
            return curr.val;
        }

        // Get next largest value
        public int getPrev(){
            TreeNode curr = prevSt.pop();
            if(curr.left != null){
                pushAllToRight(curr.left);
            }
            return curr.val;
        }

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;

            // Initialize both iterators
            pushAllToLeft(root);   // smallest side
            pushAllToRight(root);  // largest side

            int left = getNext();
            int right = getPrev();

            // Two-pointer logic
            while(left < right){
                int sum = left + right;

                if(sum == k){
                    return true;
                } else if(sum > k){
                    right = getPrev();
                } else {
                    left = getNext();
                }
            }

            return false;
        }
    }

}
