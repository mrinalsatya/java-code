package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;
//https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

/*
⏱️ Time Complexity
Worst Case:
O(m^V)

Why?

For each of the V vertices, we try up to m colors

In the worst case, all combinations are explored

⚠️ This is expected — graph coloring is an NP-Complete problem

🧮 Space Complexity
O(V + E)

Breakdown:

Adjacency list → O(V + E)

Color array → O(V)

Recursion stack → O(V)
 */
public class MColoringProblem {
    class Solution {

        // Checks whether we can assign `toPaint` color to `node`
        // without violating graph coloring rules
        public boolean isPossible(int node, int toPaint,
                                  List<List<Integer>> adj, int[] color) {
            // Check all adjacent vertices
            for (int neighbour : adj.get(node)) {
                // If any neighbour already has the same color → not possible
                if (color[neighbour] == toPaint) {
                    return false;
                }
            }
            return true;
        }

        // Backtracking function to try coloring nodes one by one
        public boolean solve(int node, int totalNodes,
                             List<List<Integer>> adj, int m, int[] color) {

            // Base case: all nodes are successfully colored
            if (node == totalNodes) {
                return true;
            }

            // Try all m colors for the current node
            for (int c = 0; c < m; c++) {
                if (isPossible(node, c, adj, color)) {
                    // Choose
                    color[node] = c;

                    // Explore
                    if (solve(node + 1, totalNodes, adj, m, color)) {
                        return true;
                    }

                    // Un-choose (backtrack)
                    color[node] = -1;
                }
            }

            // No color worked for this node
            return false;
        }

        // Main function
        boolean graphColoring(int v, int[][] edges, int m) {

            // Step 1: Build adjacency list
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            // Step 2: Color array (-1 means uncolored)
            int[] color = new int[v];
            Arrays.fill(color, -1);

            // Step 3: Start backtracking from node 0
            return solve(0, v, adj, m, color);
        }
    }

}
