package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/same-tree/description/
/*
Key Idea (Interview Explanation)
 - Traverse both trees simultaneously
 - At every node:
  - Both must be null OR
  - Both must exist and have the same value
 - Recursively verify left and right subtrees

Complexity (Optimal) - TC: O(n) Each node visited once |
SC: O(h) Recursion stack - Worst case: O(n) (skewed tree) - Best case: O(log n) (balanced tree)
 */
public class CheckIfTwoTreesAreIdentical {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {

            // If both nodes are null, trees are identical at this branch
            if (p == null && q == null) {
                return true;
            }

            // If one is null and the other is not, trees differ
            if (p == null || q == null) {
                return false;
            }

            // If values differ, trees are not the same
            if (p.val != q.val) {
                return false;
            }

            // Recursively compare left subtrees
            boolean left = isSameTree(p.left, q.left);

            // Recursively compare right subtrees
            boolean right = isSameTree(p.right, q.right);

            // Trees are same only if both subtrees match
            return left && right;
        }
    }

}
