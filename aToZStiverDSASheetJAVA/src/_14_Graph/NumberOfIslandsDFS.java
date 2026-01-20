package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslandsDFS {
    class Solution {

        // Direction vectors: up, right, down, left
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        // Checks whether the cell is inside the grid and is land ('1')
        public boolean isValid(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
                return false;
            if (grid[i][j] != '1')
                return false;

            return true;
        }

        // DFS to mark the entire island as visited
        public void dfs(char[][] grid, int i, int j) {
            // Mark current cell as visited (change '1' to '2')
            grid[i][j] = '2';

            // Explore all 4 directions
            for (int dir = 0; dir < 4; dir++) {
                int ni = i + rows[dir];
                int nj = j + cols[dir];
                if (isValid(grid, ni, nj)) {
                    dfs(grid, ni, nj);
                }
            }
        }

        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int count = 0;

            // Traverse every cell
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // When we find unvisited land, it's a new island
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);  // Mark the whole island
                        count++;          // Increase island count
                    }
                }
            }

            return count;
        }
    }

}
