package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;

//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

/*
⏱️ Time Complexity - O(4^(n^2))
Explanation:

The maze has n × n cells.

From each cell, the rat can move in 4 directions: Down, Left, Right, Up.

In the worst case (all cells are 1), the DFS explores all possible paths.

Backtracking generates an exponential number of paths, hence

💾 Space Complexity - O(n^2)
Visited array → boolean[n][n] → O(n²)

Recursion stack → max depth = number of cells → O(n²)

Path (StringBuilder) → max length = n² → O(n²) (temporary)
 */
public class RatInAMaze {
    class Solution {

        // Direction vectors for movement:
        // Down, Left, Right, Up (lexicographical order)
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        /**
         * helper() performs DFS with backtracking to find all valid paths
         * from current cell (i, j) to destination (n-1, n-1).
         */
        void helper(int[][] maze, int i, int j,
                    StringBuilder path,
                    ArrayList<String> ans,
                    boolean[][] visited) {

            int n = maze.length;

            // ✅ Base case: destination reached
            if (i == n - 1 && j == n - 1) {
                ans.add(path.toString()); // store the current path
                return;
            }

            // 🔒 Mark current cell as visited to avoid revisiting
            visited[i][j] = true;

            // Try all 4 possible directions
            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k]; // next row
                int nj = j + dy[k]; // next column

                // Check for:
                // 1. Inside grid bounds
                // 2. Open cell (value = 1)
                // 3. Not visited already
                if (ni >= 0 && nj >= 0 &&
                        ni < n && nj < n &&
                        maze[ni][nj] == 1 &&
                        !visited[ni][nj]) {

                    // Choose the direction
                    path.append(dir[k]);

                    // Explore further
                    helper(maze, ni, nj, path, ans, visited);

                    // 🔙 Backtrack: remove last move
                    path.deleteCharAt(path.length() - 1);
                }
            }

            // 🔓 Unmark current cell before returning (backtracking step)
            visited[i][j] = false;
        }

        /**
         * ratInMaze() initializes the process and returns all valid paths
         */
        public ArrayList<String> ratInMaze(int[][] maze) {

            ArrayList<String> ans = new ArrayList<>();
            int n = maze.length;

            // ❌ If start or destination is blocked, no path exists
            if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
                return ans;

            boolean[][] visited = new boolean[n][n];

            // Start DFS from top-left corner
            helper(maze, 0, 0, new StringBuilder(), ans, visited);

            return ans;
        }
    }

}
