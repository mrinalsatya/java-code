package aToZStiverDSASheetJAVA.src._14_Graph;
//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class NumberOfDistinctIslands {
    // User function Template for Java
    class Solution {

        int[][] vis;
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        // Stores unique island shapes
        HashSet<List<String>> hset;

        // Check if a cell is inside grid, unvisited, and land (1)
        public boolean isValid(int[][] grid, int r, int c) {
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
                return false;
            if (vis[r][c] == 1 || grid[r][c] == 0)
                return false;
            return true;
        }

        // DFS to explore one island and record its shape
        public void dfs(int[][] grid, int r, int c, int r0, int c0, List<String> temp) {

            vis[r][c] = 1;

            // Store relative position from the starting cell (r0, c0)
            int dx = r - r0;
            int dy = c - c0;
            temp.add(dx + "_R_" + dy + "_C_");

            // Explore in 4 directions
            for (int i = 0; i < 4; i++) {
                int nr = r + rows[i];
                int nc = c + cols[i];
                if (isValid(grid, nr, nc)) {
                    dfs(grid, nr, nc, r0, c0, temp);
                }
            }
        }

        int countDistinctIslands(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            vis = new int[m][n];
            hset = new HashSet<>();   // Initialize HashSet

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (vis[i][j] != 1 && grid[i][j] == 1) {
                        List<String> temp = new ArrayList<>();
                        dfs(grid, i, j, i, j, temp); // (i, j) is the base
                        hset.add(temp);              // store island shape
                    }
                }
            }

            return hset.size();
        }
    }

}
