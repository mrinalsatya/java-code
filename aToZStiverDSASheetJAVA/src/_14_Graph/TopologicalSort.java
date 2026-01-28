package aToZStiverDSASheetJAVA.src._14_Graph;
//https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
    class Solution {
        int[] vis;                 // vis[i] = 1 means node i is already visited
        Stack<Integer> st;         // Stack to store the topological order
        List<List<Integer>> adj;   // Adjacency list

        // DFS to perform post-order traversal
        public void dfs(int node) {
            vis[node] = 1;         // Mark current node as visited

            // Visit all unvisited neighbors
            for (Integer nei : adj.get(node)) {
                if (vis[nei] == 0) {
                    dfs(nei);
                }
            }

            // After visiting all neighbors, push node to stack
            // This ensures dependencies come before the node
            st.push(node);
        }

        public ArrayList<Integer> topoSort(int V, int[][] edges) {
            vis = new int[V];
            st = new Stack<>();
            adj = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();

            // Initialize adjacency list
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            // Build graph from edge list (directed edges u -> v)
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                adj.get(u).add(v);
            }

            // Run DFS from every unvisited node
            // (Graph may be disconnected)
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    dfs(i);
                }
            }

            // Pop nodes from stack to get topological order
            while (!st.isEmpty()) {
                ans.add(st.pop());
            }

            return ans;
        }
    }

}
