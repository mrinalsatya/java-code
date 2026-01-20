package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslandsBFS {
    class Solution {

        class Pair {
            int i, j;
            Pair(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        // Direction vectors: up, right, down, left
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        // Check if the cell is inside grid and is unvisited land
        public boolean isValid(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
                return false;
            return grid[i][j] == '1';
        }

        // BFS to mark the entire island
        public void bfs(char[][] grid, int i, int j) {
            Queue<Pair> q = new LinkedList<>();

            // Push starting cell and mark it visited
            q.offer(new Pair(i, j));
            grid[i][j] = '2';

            while (!q.isEmpty()) {
                Pair curr = q.poll();
                int curri = curr.i;
                int currj = curr.j;

                // Explore 4 directions
                for (int dir = 0; dir < 4; dir++) {
                    int ni = curri + rows[dir];
                    int nj = currj + cols[dir];

                    if (isValid(grid, ni, nj)) {
                        grid[ni][nj] = '2';          // mark visited immediately
                        q.offer(new Pair(ni, nj));  // enqueue neighbor
                    }
                }
            }
        }

        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int count = 0;

            // Traverse all cells
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        bfs(grid, i, j); // mark entire island
                        count++;         // new island found
                    }
                }
            }

            return count;
        }
    }

}
