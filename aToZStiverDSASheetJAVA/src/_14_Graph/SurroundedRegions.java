package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
    class Solution {
        int[][] vis;                       // To mark visited cells
        int[] rows = {-1, 0, 1, 0};        // Row movement (up, right, down, left)
        int[] cols = {0, 1, 0, -1};        // Column movement

        // DFS to mark all 'O's connected to the boundary
        public void dfs(char[][] grid, int r, int c) {
            // Stop if:
            // - Out of bounds
            // - Already visited
            // - Cell is 'X'
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                    || vis[r][c] == 1 || grid[r][c] == 'X') {
                return;
            }

            // Mark current cell as visited (safe 'O')
            vis[r][c] = 1;

            // Explore in all 4 directions
            for (int i = 0; i < 4; i++) {
                dfs(grid, r + rows[i], c + cols[i]);
            }
        }

        public void solve(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            vis = new int[m][n];

            /*
             * Step 1:
             * Run DFS from all boundary 'O' cells.
             * Any 'O' connected to the boundary cannot be flipped.
             */
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                            && vis[i][j] == 0 && grid[i][j] == 'O') {
                        dfs(grid, i, j);
                    }
                }
            }

            /*
             * Step 2:
             * All remaining 'O's that are not visited are surrounded.
             * Flip them to 'X'.
             */
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (vis[i][j] != 1 && grid[i][j] == 'O') {
                        grid[i][j] = 'X';
                    }
                }
            }
        }
    }

}
