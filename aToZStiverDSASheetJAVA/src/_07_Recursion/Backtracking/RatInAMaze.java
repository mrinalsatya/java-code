package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;

//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInAMaze {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'D', 'L', 'R', 'U'};

    void helper(int[][] maze, int i, int j, StringBuilder path, ArrayList<String> ans, boolean[][] visited) {
        int n = maze.length;

        if(i == n-1 && j == n-1) {
            ans.add(path.toString());
            return;
        }

        visited[i][j] = true;

        for(int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if(ni >= 0 && nj >= 0 && ni < n && nj < n && maze[ni][nj] == 1 && !visited[ni][nj]) {
                path.append(dir[k]);
                helper(maze, ni, nj, path, ans, visited);
                path.deleteCharAt(path.length()-1);
            }
        }

        visited[i][j] = false;
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        if(maze[0][0] == 0 || maze[n-1][n-1] == 0) return ans;
        helper(maze, 0, 0, new StringBuilder(), ans, visited);
        return ans;
    }
}
