package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
/*
sorting by three rules:
1️⃣ Column → left to right
2️⃣ Row → top to bottom
3️⃣ Value → if same row & column

How your solution satisfies this:
 - BFS (Queue) → guarantees correct row order
 - TreeMap (column) → auto-sorts columns
 - TreeMap (row) → auto-sorts rows
 - PriorityQueue → sorts values at same row & column
Complexity Analysis : TC: O(n log n) | TreeMap insertions + priority queue operations | SC: O(n) - Queue + maps + heaps
 */
public class TraversalVerticalOrder {
    class Solution {

        // Helper class to store node along with its row and column
        class Pair {
            TreeNode node;
            int row, col;

            Pair(TreeNode node, int row, int col) {
                this.node = node;
                this.row = row;
                this.col = col;
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {

            // Result list
            List<List<Integer>> ans = new ArrayList<>();

            /**
             * Data structure:
             * column -> row -> min-heap of node values
             *
             * TreeMap ensures:
             *  - columns are processed from left to right
             *  - rows are processed from top to bottom
             *
             * PriorityQueue ensures:
             *  - nodes at same row & column are sorted by value
             */
            Map<Integer, Map<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();

            // BFS queue to ensure top-to-bottom traversal
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0, 0)); // root at row 0, column 0

            // Perform BFS
            while (!q.isEmpty()) {
                Pair temp = q.poll();

                // Insert node value into correct column and row
                mp
                        .computeIfAbsent(temp.col, k -> new TreeMap<>())
                        .computeIfAbsent(temp.row, k -> new PriorityQueue<>())
                        .offer(temp.node.val);

                // Move left: row + 1, column - 1
                if (temp.node.left != null) {
                    q.offer(new Pair(temp.node.left, temp.row + 1, temp.col - 1));
                }

                // Move right: row + 1, column + 1
                if (temp.node.right != null) {
                    q.offer(new Pair(temp.node.right, temp.row + 1, temp.col + 1));
                }
            }

            // Build final answer
            for (Map<Integer, PriorityQueue<Integer>> rows : mp.values()) {
                List<Integer> colList = new ArrayList<>();

                for (PriorityQueue<Integer> pq : rows.values()) {
                    while (!pq.isEmpty()) {
                        colList.add(pq.poll());
                    }
                }

                ans.add(colList);
            }

            return ans;
        }
    }
}
