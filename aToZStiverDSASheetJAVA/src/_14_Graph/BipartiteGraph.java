package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/is-graph-bipartite/
public class BipartiteGraph {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;

            // visited[i] = -1  -> not colored yet
            // visited[i] = 0   -> color 0
            // visited[i] = 1   -> color 1
            int[] visited = new int[n];
            Arrays.fill(visited, -1);

            // We must check all components (graph may be disconnected)
            for (int i = 0; i < n; i++) {
                if (visited[i] == -1) {

                    // Start BFS from this unvisited node
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    visited[i] = 0;   // Assign first color

                    while (!q.isEmpty()) {
                        int curr = q.poll();

                        // Traverse all neighbors
                        for (int nei : graph[curr]) {

                            // If neighbor has same color -> not bipartite
                            if (visited[nei] != -1 && visited[nei] == visited[curr]) {
                                return false;
                            }

                            // If neighbor is unvisited, color it with opposite color
                            if (visited[nei] == -1) {
                                visited[nei] = (visited[curr] == 1) ? 0 : 1;
                                q.offer(nei);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }

}
