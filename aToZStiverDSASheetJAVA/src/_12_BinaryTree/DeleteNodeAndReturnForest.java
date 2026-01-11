package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/delete-nodes-and-return-forest/
/*
 - We use postorder traversal so children are handled before the parent
 - When a node is deleted:
 - Its children (if not deleted) become new roots
 - Returning null cleanly disconnects deleted nodes
 - The root is handled separately at the end
 */
public class DeleteNodeAndReturnForest {
    class Solution {

        // Stores roots of all trees in the resulting forest
        List<TreeNode> forest = new ArrayList<>();

        // Set for quick lookup of nodes to delete
        Set<Integer> deleteSet = new HashSet<>();

        /**
         * Postorder DFS
         * Returns:
         *  - the node itself if it should remain
         *  - null if the node is deleted
         */
        public TreeNode getForest(TreeNode root) {

            // Base case
            if (root == null) {
                return null;
            }

            // Process children first (postorder)
            root.left = getForest(root.left);
            root.right = getForest(root.right);

            // If current node needs to be deleted
            if (deleteSet.contains(root.val)) {

                // Its non-null children become new roots in the forest
                if (root.left != null) {
                    forest.add(root.left);
                }
                if (root.right != null) {
                    forest.add(root.right);
                }

                // Returning null disconnects this node from its parent
                return null;
            }

            // Keep the current node
            return root;
        }

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

            // Edge case: empty tree
            if (root == null) {
                return forest;
            }

            // Populate delete set
            for (int num : to_delete) {
                deleteSet.add(num);
            }

            // Process the tree
            TreeNode remainingTree = getForest(root);

            // If root itself is not deleted, add it to the forest
            if (remainingTree != null) {
                forest.add(remainingTree);
            }

            return forest;
        }
    }

}
