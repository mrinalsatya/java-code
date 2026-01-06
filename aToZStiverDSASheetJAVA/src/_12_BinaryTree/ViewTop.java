package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
/*
Complexity - TC: O(n log n) - n insertions into TreeMap | SC: O(n)
If we use HashMap and min max level, TC will be O(n)
 */
public class ViewTop {
    class Solution {

        // Pair to store node with its horizontal distance (column)
        class Pair {
            Node node;
            int col;

            Pair(Node node, int col) {
                this.node = node;
                this.col = col;
            }
        }

        public ArrayList<Integer> topView(Node root) {

            ArrayList<Integer> ans = new ArrayList<>();

            // Edge case: empty tree
            if (root == null) return ans;

            /**
             * TreeMap stores:
             * column -> node value
             * Columns are automatically sorted from left to right
             */
            TreeMap<Integer, Integer> mp = new TreeMap<>();

            // Queue for BFS traversal
            Queue<Pair> q = new LinkedList<>();

            // Start BFS from root at column 0
            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {

                Pair curr = q.poll();
                int col = curr.col;
                Node node = curr.node;

                // Store the first node encountered at this column
                // (topmost node due to BFS)
                mp.putIfAbsent(col, node.data);

                // Move left child to column - 1
                if (node.left != null) {
                    q.offer(new Pair(node.left, col - 1));
                }

                // Move right child to column + 1
                if (node.right != null) {
                    q.offer(new Pair(node.right, col + 1));
                }
            }

            // TreeMap keeps keys sorted, so just collect values
            for (int val : mp.values()) {
                ans.add(val);
            }

            return ans;
        }
    }

}
