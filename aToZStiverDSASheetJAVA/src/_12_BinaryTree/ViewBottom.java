package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
/*
Complexity - TC: O(n log n) - n insertions into TreeMap | SC: O(n)
If we use HashMap and min max level, TC will be O(n)
 */
public class ViewBottom {
    class Solution {

        // Pair to store a node with its horizontal distance (column)
        class Pair {
            int col;
            Node node;

            Pair(Node node, int col) {
                this.node = node;
                this.col = col;
            }
        }

        public ArrayList<Integer> bottomView(Node root) {

            // Result list
            ArrayList<Integer> ans = new ArrayList<>();

            // Edge case: empty tree
            if (root == null) return ans;

            /**
             * TreeMap stores:
             * column -> node value
             * Automatically keeps columns sorted (left to right)
             */
            Map<Integer, Integer> mp = new TreeMap<>();

            // Queue for BFS traversal
            Queue<Pair> q = new LinkedList<>();

            // Start BFS from root at column 0
            q.offer(new Pair(root, 0));

            // Perform BFS
            while (!q.isEmpty()) {

                Pair curr = q.poll();
                int col = curr.col;
                Node temp = curr.node;

                // For bottom view, overwrite the value at this column
                // BFS ensures deeper nodes replace earlier ones
                mp.put(col, temp.data);

                // Move left child to column - 1
                if (temp.left != null) {
                    q.offer(new Pair(temp.left, col - 1));
                }

                // Move right child to column + 1
                if (temp.right != null) {
                    q.offer(new Pair(temp.right, col + 1));
                }
            }

            // Collect result in left-to-right order
            for (int val : mp.values()) {
                ans.add(val);
            }

            return ans;
        }
    }

}
