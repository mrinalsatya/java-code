package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;
//https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
public class MColoringProblem {
    public boolean isPossible(int node, int toPaint, List<List<Integer>> adj, int[] color){
        for(int neighbour : adj.get(node)){
            if(color[neighbour] == toPaint)
                return false;
        }

        return true;
    }
    public boolean solve(int node, int totalNodes, List<List<Integer>> adj, int m, int[] color){
        if(node == totalNodes){
            return true;
        }

        for(int i=0; i<m; i++){
            if(isPossible(node, i, adj, color)){
                color[node] = i;
                if(solve(node+1, totalNodes, adj, m, color))
                    return true;
                color[node] = -1;
            }
        }

        return false;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<v; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] color = new int[v];
        Arrays.fill(color, -1);

        return solve(0, v, adj, m, color);
    }
}
