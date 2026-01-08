package aToZStiverDSASheetJAVA.src._12_BinaryTree;
/*
Strategy
 - Take the last element from postorder as root
 - Locate root in inorder traversal
 - Elements right of root in inorder → right subtree
 - Elements left of root in inorder → left subtree
 - Build right subtree first because we are consuming postorder backwards
Complexity (Optimal) : TC: O(n) - Each node is processed once - HashMap lookup is O(1)
                       SC: O(n) - HashMap + recursion stack
 */
public class ConstructTreeFromPostOrder {
    class Solution {

        // Map to store value -> index mapping for inorder traversal
        // Enables O(1) lookup of root position
        Map<Integer, Integer> inorderMap = new HashMap<>();

        // Pointer to track current index in postorder traversal
        int postPos = 0;

        /**
         * Recursive helper to construct the tree
         *
         * inorder   -> inorder traversal array
         * postorder -> postorder traversal array
         * inStart   -> start index in inorder array
         * inEnd     -> end index in inorder array
         */
        public TreeNode solve(int[] inorder, int[] postorder, int inStart, int inEnd) {

            // Base case: no elements to construct subtree
            if (inStart > inEnd || postPos < 0) {
                return null;
            }

            // Pick current root from postorder traversal
            TreeNode root = new TreeNode(postorder[postPos--]);

            // Find root position in inorder traversal
            int inPos = inorderMap.get(root.val);

            // IMPORTANT:
            // Build right subtree first (because postorder is Left → Right → Root)
            root.right = solve(inorder, postorder, inPos + 1, inEnd);

            // Build left subtree
            root.left = solve(inorder, postorder, inStart, inPos - 1);

            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {

            // Build value -> index map for inorder traversal
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            // Initialize postorder pointer to last index
            postPos = postorder.length - 1;

            // Construct tree using full inorder range
            return solve(inorder, postorder, 0, inorder.length - 1);
        }
    }

}
