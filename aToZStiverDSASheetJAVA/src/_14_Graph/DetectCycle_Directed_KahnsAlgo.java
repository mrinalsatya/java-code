package aToZStiverDSASheetJAVA.src._14_Graph;

public class DetectCycle_Directed_KahnsAlgo {
    class Solution {
        public boolean isCyclic(int V, int[][] edges) {
            // code here
            ArrayList<Integer> ans = new ArrayList<>();
            List<List<Integer>> adj = new ArrayList<>();
            int[] indegree = new int[V];
            for(int i=0; i<V; i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0; i<edges.length; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                adj.get(u).add(v);
                indegree[v]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<V; i++){
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }

            while(!q.isEmpty()){
                int node = q.poll();
                ans.add(node);
                for(Integer nei : adj.get(node)){
                    indegree[nei]--;
                    if(indegree[nei] == 0){
                        q.offer(nei);
                    }
                }
            }

            return ans.size() == V ? false : true;
        }
    }
}
