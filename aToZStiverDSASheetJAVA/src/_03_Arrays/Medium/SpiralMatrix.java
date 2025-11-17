package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;

public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int row = matrix.length, col = matrix[0].length;
            int top = 0, right = col - 1, down = row - 1, left = 0;

            while (top <= down && left <= right) {
                // traverse top row
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;

                // traverse right column
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;

                // traverse bottom row (check boundary)
                if (top <= down) {
                    for (int i = right; i >= left; i--) {
                        ans.add(matrix[down][i]);
                    }
                    down--;
                }

                // traverse left column (check boundary)
                if (left <= right) {
                    for (int i = down; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                    left++;
                }
            }

            return ans;
        }
    }
}
