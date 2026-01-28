package aToZStiverDSASheetJAVA.src._14_Graph;
//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class DetectCycle_DirectedGraph {
    class Solution {
        int[] visited;        // Marks nodes that are fully processed
        int[] pathVisited;    // Marks nodes in the current DFS recursion path
        List<List<Integer>> adj;

        // DFS to detect cycle in directed graph
        public boolean dfs(int node) {
            visited[node] = 1;
            pathVisited[node] = 1;

            for (Integer nei : adj.get(node)) {

                // If neighbor is already in current recursion path → cycle
                if (visited[nei] == 1 && pathVisited[nei] == 1) {
                    return true;
                }

                // If neighbor is not visited, explore it
                if (visited[nei] == 0) {
                    if (dfs(nei)) {
                        return true;
                    }
                }
            }

            // Remove node from current path before backtracking
            pathVisited[node] = 0;
            return false;
        }

        public boolean isCyclic(int V, int[][] edges) {
            visited = new int[V];
            pathVisited = new int[V];
            adj = new ArrayList<>();

            // Build adjacency list
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                adj.get(u).add(v);   // Directed edge u -> v
            }

            // Check each component
            for (int i = 0; i < V; i++) {
                if (visited[i] == 0) {
                    if (dfs(i)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

}
