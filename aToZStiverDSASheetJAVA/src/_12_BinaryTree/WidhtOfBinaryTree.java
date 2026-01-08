package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/maximum-width-of-binary-tree/
/*
Why This Works (Interview Explanation)
 - We perform level-order traversal (BFS)
 - Each node is assigned an index as if the tree were complete
 - Width of a level = lastIndex - firstIndex + 1
 - We normalize indices per level to avoid overflow

TC - O(n) | SC - O(n)
 */
public class WidhtOfBinaryTree {
    class Solution {

        class Pair {
            TreeNode node;
            int index;

            Pair(TreeNode node, int index) {
                this.node = node;
                this.index = index;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {

            if (root == null) return 0;

            int maxWidth = 0;

            // BFS queue
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {

                int size = q.size();
                int minIndex = q.peek().index; // normalize to prevent overflow
                int first = 0, last = 0;

                for (int i = 0; i < size; i++) {

                    Pair curr = q.poll();
                    TreeNode node = curr.node;

                    int idx = curr.index - minIndex;

                    if (i == 0) first = idx;
                    if (i == size - 1) last = idx;

                    // Correct child index assignment
                    if (node.left != null) {
                        q.offer(new Pair(node.left, 2 * idx));
                    }

                    if (node.right != null) {
                        q.offer(new Pair(node.right, 2 * idx + 1));
                    }
                }

                maxWidth = Math.max(maxWidth, last - first + 1);
            }

            return maxWidth;
        }
    }

}
