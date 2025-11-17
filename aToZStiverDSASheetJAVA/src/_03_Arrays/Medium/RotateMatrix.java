package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;

public class RotateMatrix {
    class Solution {
        public static void swap(int[][] arr, int i, int j) {
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
        public static void reverse(int[] arr, int i, int j) {
            while(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        public void rotate(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            for(int i = 0; i< n; i++){
                for(int j = i; j< m ; j++){
                    if(i==j)
                        continue;
                    System.out.println("i = " + i +  " j = " + j);
                    swap(matrix, i, j);
                }
            }

            for(int i = 0; i< n; i++){
                reverse(matrix[i], 0, m-1);
            }

        }
    }
}
