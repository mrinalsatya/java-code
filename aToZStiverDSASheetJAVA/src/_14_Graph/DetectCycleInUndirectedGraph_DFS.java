package aToZStiverDSASheetJAVA.src._14_Graph;
//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class DetectCycleInUndirectedGraph_DFS {
    class Solution {

        // Helper class to keep track of current node and its parent
        class Pair {
            int node, parent;
            Pair(int node, int parent) {
                this.node = node;
                this.parent = parent;
            }
        }

        List<List<Integer>> adj;  // Adjacency list
        boolean[] vis;            // Visited array

        // DFS function to detect cycle starting from a given node
        public boolean hasCycle(Pair curr) {

            // Mark current node as visited
            vis[curr.node] = true;

            // Traverse all neighbors of current node
            for (Integer nei : adj.get(curr.node)) {

                // Ignore the edge going back to parent
                if (nei != curr.parent) {

                    // If neighbor is already visited and not parent → cycle
                    if (vis[nei]) return true;

                    // Recurse for the neighbor
                    if (hasCycle(new Pair(nei, curr.node))) {
                        return true;
                    }
                }
            }

            // No cycle found from this path
            return false;
        }

        public boolean isCycle(int V, int[][] edges) {

            // Step 1: Build adjacency list
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            // Convert edge list to adjacency list (undirected graph)
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            // Initialize visited array
            vis = new boolean[V];

            // Step 2: Run DFS from every unvisited node
            // (Graph may be disconnected)
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    if (hasCycle(new Pair(i, -1))) {
                        return true; // Cycle detected
                    }
                }
            }

            // No cycle in any component
            return false;
        }
    }

}
