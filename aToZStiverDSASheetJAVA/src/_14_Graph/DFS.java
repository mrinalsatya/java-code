package aToZStiverDSASheetJAVA.src._14_Graph;
//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class DFS {
    class Solution {

        ArrayList<Integer> ans = new ArrayList<>(); // Stores DFS traversal
        boolean[] vis;                              // Tracks visited nodes

        // Recursive DFS function
        public void solve(ArrayList<ArrayList<Integer>> adj, int node) {
            ans.add(node);          // Visit the current node
            vis[node] = true;       // Mark it as visited

            // Traverse all unvisited neighbors
            for (Integer neighbour : adj.get(node)) {
                if (!vis[neighbour]) {
                    solve(adj, neighbour); // DFS call
                }
            }
        }

        public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
            int n = adj.size();
            vis = new boolean[n];   // Initialize visited array

            // Start DFS from node 0
            solve(adj, 0);

            return ans;
        }
    }

}
