package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/number-of-enclaves/
public class NumberOfEnclaves {
    class Solution {
        int[][] vis;                          // To mark visited cells
        int[] rows = {-1, 0, 1, 0};           // Direction vectors for row movement
        int[] cols = {0, 1, 0, -1};           // Direction vectors for column movement

        // DFS to mark all land cells connected to the boundary
        public void dfs(int[][] grid, int r, int c) {
            // Base conditions:
            // - Out of bounds
            // - Already visited
            // - Water cell (0)
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                    || vis[r][c] == 1 || grid[r][c] == 0) {
                return;
            }

            // Mark current land cell as visited
            vis[r][c] = 1;

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                dfs(grid, r + rows[i], c + cols[i]);
            }
        }

        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            vis = new int[m][n];

            /*
             * Step 1:
             * Run DFS from all boundary land cells.
             * Any land connected to the boundary cannot be an enclave.
             */
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // Check only boundary cells
                    if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                            && vis[i][j] == 0 && grid[i][j] == 1) {
                        dfs(grid, i, j);
                    }
                }
            }

            /*
             * Step 2:
             * Count all remaining land cells that are:
             * - Not visited
             * - Not on the boundary
             * These are the enclaves.
             */
            int count = 0;
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (vis[i][j] == 0 && grid[i][j] == 1) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
