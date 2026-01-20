package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    //With Adjacency list
    class Solution {

        List<List<Integer>> adj;
        boolean[] vis;

        // Standard DFS to mark all nodes in the same component
        public void dfs(int node) {
            vis[node] = true;
            for (Integer neighbour : adj.get(node)) {
                if (!vis[neighbour]) {
                    dfs(neighbour);
                }
            }
        }

        public int findCircleNum(int[][] isConnected) {
            int v = isConnected.length;

            vis = new boolean[v];
            adj = new ArrayList<>();

            // Initialize adjacency list
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }

            // Convert adjacency matrix to adjacency list
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (isConnected[i][j] == 1 && i != j) {
                        adj.get(i).add(j);
                    }
                }
            }

            int count = 0;

            // Count connected components
            for (int i = 0; i < v; i++) {
                if (!vis[i]) {
                    count++;       // New province found
                    dfs(i);        // Mark all cities in this province
                }
            }

            return count;
        }
    }

    //Without
    class Solution {

        boolean[] vis;

        // DFS directly on the adjacency matrix
        public void dfs(int[][] isConnected, int node) {
            vis[node] = true;

            // Check all possible neighbors
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[node][j] == 1 && !vis[j]) {
                    dfs(isConnected, j);
                }
            }
        }

        public int findCircleNum(int[][] isConnected) {
            int v = isConnected.length;
            vis = new boolean[v];
            int count = 0;

            // Count connected components
            for (int i = 0; i < v; i++) {
                if (!vis[i]) {
                    count++;          // New province found
                    dfs(isConnected, i);
                }
            }

            return count;
        }
    }

}
