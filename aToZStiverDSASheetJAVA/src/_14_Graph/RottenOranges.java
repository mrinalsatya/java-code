package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/rotting-oranges/
public class RottenOranges {
    class Solution {

        // Helper class to store cell position and the time at which it becomes rotten
        class Pair {
            int row, col, time;
            Pair(int row, int col, int time) {
                this.row = row;
                this.col = col;
                this.time = time;
            }
        }

        public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            // vis[r][c] = 1 means this cell has already been processed (rotten/visited)
            int[][] vis = new int[m][n];

            int freshCount = 0;  // total number of fresh oranges
            int time = 0;        // stores the maximum time taken to rot all oranges

            // Queue for multi-source BFS
            Queue<Pair> q = new LinkedList<>();

            // Step 1: Push all initially rotten oranges into the queue
            // Also count the number of fresh oranges
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        // Rotten orange: start BFS from here with time = 0
                        q.offer(new Pair(i, j, 0));
                        vis[i][j] = 1;
                    } else if (grid[i][j] == 1) {
                        // Fresh orange
                        freshCount++;
                    }
                }
            }

            // Direction arrays for 4-directional movement (up, right, down, left)
            int[] rows = {-1, 0, 1, 0};
            int[] cols = {0, 1, 0, -1};

            // Step 2: BFS traversal
            while (!q.isEmpty()) {
                Pair curr = q.poll();

                // Update the maximum time seen so far
                time = Math.max(time, curr.time);

                // Explore all 4 neighbors
                for (int i = 0; i < 4; i++) {
                    int ni = curr.row + rows[i];
                    int nj = curr.col + cols[i];
                    int nt = curr.time + 1;

                    // Check bounds, ensure it's unvisited and is a fresh orange
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n &&
                            vis[ni][nj] != 1 && grid[ni][nj] == 1) {

                        // Mark as visited/rotten
                        vis[ni][nj] = 1;

                        // Push into queue with incremented time
                        q.offer(new Pair(ni, nj, nt));

                        // One fresh orange is now rotten
                        freshCount--;
                    }
                }
            }

            // If some fresh oranges are still left, it's impossible to rot all
            return freshCount > 0 ? -1 : time;
        }
    }

}
