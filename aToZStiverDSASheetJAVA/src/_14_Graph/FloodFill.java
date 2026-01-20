package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/flood-fill/
public class FloodFill {
    class Solution {
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        public void dfs(int[][] image, int i, int j, int color, int initColor) {
            // Boundary + invalid color check
            if (i < 0 || i >= image.length || j < 0 || j >= image[0].length)
                return;
            if (image[i][j] != initColor)
                return;

            // Recolor current cell
            image[i][j] = color;

            // Explore 4 directions
            for (int d = 0; d < 4; d++) {
                dfs(image, i + rows[d], j + cols[d], color, initColor);
            }
        }

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int initColor = image[sr][sc];

            // Important: if color is same, no work needed (prevents infinite loop)
            if (initColor == color) return image;

            dfs(image, sr, sc, color, initColor);
            return image;
        }
    }

}
