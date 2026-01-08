package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeAndDeserialize {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        /**
         * SERIALIZE
         * Converts a binary tree into a string using level-order traversal.
         */
        public String serialize(TreeNode root) {

            // Edge case: empty tree
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            // BFS traversal
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();

                // Null node marker
                if (curr == null) {
                    sb.append("#,");
                    continue;
                }

                // Append current value
                sb.append(curr.val).append(",");

                // Push children (even if null)
                q.offer(curr.left);
                q.offer(curr.right);
            }

            return sb.toString();
        }

        /**
         * DESERIALIZE
         * Reconstructs the binary tree from the serialized string.
         */
        public TreeNode deserialize(String data) {

            // Edge case: empty string
            if (data == null || data.length() == 0) return null;

            String[] values = data.split(",");

            // Create root
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int i = 1;

            // BFS reconstruction
            while (!q.isEmpty() && i < values.length) {
                TreeNode curr = q.poll();

                // Left child
                if (!values[i].equals("#")) {
                    curr.left = new TreeNode(Integer.parseInt(values[i]));
                    q.offer(curr.left);
                }
                i++;

                // Right child
                if (i < values.length && !values[i].equals("#")) {
                    curr.right = new TreeNode(Integer.parseInt(values[i]));
                    q.offer(curr.right);
                }
                i++;
            }

            return root;
        }
    }

}
