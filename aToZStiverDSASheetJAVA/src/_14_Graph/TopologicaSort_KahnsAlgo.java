package aToZStiverDSASheetJAVA.src._14_Graph;
//https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicaSort_KahnsAlgo {
    class Solution {
        public ArrayList<Integer> topoSort(int V, int[][] edges) {

            ArrayList<Integer> ans = new ArrayList<>();
            List<List<Integer>> adj = new ArrayList<>();

            // indegree[i] = number of incoming edges to node i
            int[] indegree = new int[V];

            // Step 1: Initialize adjacency list
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            // Step 2: Build graph and compute indegrees
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                adj.get(u).add(v);   // Directed edge u -> v
                indegree[v]++;       // Increase indegree of v
            }

            // Step 3: Push all nodes with indegree 0 into queue
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            // Step 4: Process nodes using BFS
            while (!q.isEmpty()) {
                int node = q.poll();
                ans.add(node);       // Add node to topological order

                // Reduce indegree of all neighbors
                for (Integer nei : adj.get(node)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }

            return ans;
        }
    }

}
