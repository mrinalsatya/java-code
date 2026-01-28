package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/find-eventual-safe-states/description/
public class FindEventualSafeStates_DFS {
    class Solution {
        int[] vis;        // Marks if a node has been visited
        int[] pathVis;    // Marks nodes in the current DFS recursion stack
        int[] check;      // check[i] = 1 means node i is safe

        // DFS to detect cycle and mark safe nodes
        public boolean dfs(int[][] graph, int node) {
            vis[node] = 1;        // Mark as visited
            pathVis[node] = 1;    // Mark as part of current path

            for (int nei : graph[node]) {

                // If neighbor is not visited, explore it
                if (vis[nei] == 0) {
                    if (dfs(graph, nei)) {
                        return true;   // Cycle detected below
                    }
                }
                // If neighbor is already in current path -> cycle
                else if (pathVis[nei] == 1) {
                    return true;
                }
            }

            // If we reach here, no cycle was found from this node
            check[node] = 1;      // Mark this node as safe
            pathVis[node] = 0;    // Remove from current path while backtracking
            return false;
        }

        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            List<Integer> ans = new ArrayList<>();

            vis = new int[n];
            pathVis = new int[n];
            check = new int[n];

            // Run DFS for each unvisited node
            for (int i = 0; i < n; i++) {
                if (vis[i] == 0) {
                    dfs(graph, i);
                }
            }

            // Collect all safe nodes
            for (int i = 0; i < n; i++) {
                if (check[i] == 1) {
                    ans.add(i);
                }
            }

            return ans;
        }
    }
}
