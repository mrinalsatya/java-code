package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
/*
Key Properties
 - Preorder: Root → Left → Right
 - Inorder: Left → Root → Right
Strategy
 - The first element in preorder is always the root
 - Find that root in the inorder array
 - Everything left of root in inorder → left subtree
 - Everything right of root in inorder → right subtree
 - Repeat recursively
The prePos pointer ensures preorder elements are consumed in correct order.

Complexity (Optimal) : TC: O(n) - Each node processed once - HashMap lookup is O(1) | SC: O(n) - HashMap + recursion stack
 */
public class ConstructTreeFromPreOrder {
    class Solution {

        // Map to store value -> index mapping for inorder traversal
        // This allows O(1) lookup of root position in inorder array
        Map<Integer, Integer> inorderMap = new HashMap<>();

        // Pointer to track current index in preorder array
        int prePos = 0;

        /**
         * Recursive helper function to build the tree
         * preorder  -> preorder traversal array
         * inorder   -> inorder traversal array
         * inStart   -> start index of current inorder segment
         * inEnd     -> end index of current inorder segment
         */
        public TreeNode solve(int[] preorder, int[] inorder, int inStart, int inEnd) {

            // Base case: no elements to construct subtree
            if (inStart > inEnd) {
                return null;
            }

            // Pick current root from preorder traversal
            TreeNode root = new TreeNode(preorder[prePos++]);

            // Find root position in inorder traversal
            int inPos = inorderMap.get(root.val);

            // Recursively build left subtree
            root.left = solve(preorder, inorder, inStart, inPos - 1);

            // Recursively build right subtree
            root.right = solve(preorder, inorder, inPos + 1, inEnd);

            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            // Build value -> index map for inorder traversal
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            // Construct tree starting with full inorder range
            return solve(preorder, inorder, 0, inorder.length - 1);
        }
    }

}
