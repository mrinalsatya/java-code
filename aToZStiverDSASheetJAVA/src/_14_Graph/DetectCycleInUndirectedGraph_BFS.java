package aToZStiverDSASheetJAVA.src._14_Graph;
//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class DetectCycleInUndirectedGraph_BFS {
    class Solution {

        // Helper class to store (currentNode, parentNode)
        // Parent is needed to avoid treating the edge back to parent as a cycle
        class Pair {
            int node, parent;
            Pair(int node, int parent) {
                this.node = node;
                this.parent = parent;
            }
        }

        List<List<Integer>> adj;  // Adjacency list representation of the graph
        boolean[] vis;            // Visited array

        // BFS function to detect cycle starting from a given node
        public boolean hasCycle(int start) {

            Queue<Pair> q = new LinkedList<>();

            // Start BFS from 'start' node
            q.offer(new Pair(start, -1));
            vis[start] = true;

            while (!q.isEmpty()) {
                Pair curr = q.poll();

                // Traverse all adjacent nodes
                for (Integer nei : adj.get(curr.node)) {

                    // If neighbor is not the parent
                    if (nei != curr.parent) {

                        // If already visited, a cycle is found
                        if (vis[nei]) return true;

                        // Otherwise, mark visited and continue BFS
                        vis[nei] = true;
                        q.offer(new Pair(nei, curr.node));
                    }
                }
            }

            // No cycle found in this connected component
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

            // Visited array
            vis = new boolean[V];

            // Step 2: Run BFS from every unvisited node
            // (Graph may be disconnected)
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    if (hasCycle(i)) {
                        return true; // Cycle detected
                    }
                }
            }

            // No cycle in any component
            return false;
        }
    }

}
