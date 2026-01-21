package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/01-matrix/description/
public class _01_Matrix {
    class Solution {

        // Helper class to store cell position and its distance from nearest 0
        class Pair {
            int row, col, dis;
            Pair(int row, int col, int dis) {
                this.row = row;
                this.col = col;
                this.dis = dis;
            }
        }

        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;

            int[][] vis = new int[m][n];   // marks visited cells
            int[][] dis = new int[m][n];   // stores distance to nearest 0

            Queue<Pair> q = new LinkedList<>();

            // Step 1: Push all cells with value 0 into the queue
            // These act as multiple BFS sources
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        q.offer(new Pair(i, j, 0));
                        vis[i][j] = 1;   // mark visited
                    }
                }
            }

            // Direction arrays (up, right, down, left)
            int[] rows = {-1, 0, 1, 0};
            int[] cols = {0, 1, 0, -1};

            // Step 2: BFS traversal
            while (!q.isEmpty()) {
                Pair curr = q.poll();

                // Store the shortest distance for this cell
                dis[curr.row][curr.col] = curr.dis;

                // Explore neighbors
                for (int i = 0; i < 4; i++) {
                    int ni = curr.row + rows[i];
                    int nj = curr.col + cols[i];
                    int ndis = curr.dis + 1;

                    // If valid and unvisited
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && vis[ni][nj] != 1) {
                        vis[ni][nj] = 1;
                        q.offer(new Pair(ni, nj, ndis));
                    }
                }
            }

            return dis;
        }
    }

}
