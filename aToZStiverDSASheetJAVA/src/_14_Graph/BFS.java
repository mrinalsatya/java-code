package aToZStiverDSASheetJAVA.src._14_Graph;
//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
public class BFS {
    class Solution {
        public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
            int n = adj.size();                 // Number of nodes
            ArrayList<Integer> ans = new ArrayList<>(); // Stores BFS traversal order
            Queue<Integer> q = new LinkedList<>();      // Queue for BFS
            boolean[] visited = new boolean[n];         // To avoid revisiting nodes

            // Start BFS from node 0
            q.offer(0);
            visited[0] = true;

            while (!q.isEmpty()) {
                int node = q.poll();           // Remove front element
                ans.add(node);                 // Add it to traversal

                // Visit all unvisited neighbors
                for (Integer it : adj.get(node)) {
                    if (!visited[it]) {
                        visited[it] = true;    // Mark as visited
                        q.offer(it);           // Push into queue
                    }
                }
            }

            return ans;
        }
    }

}
