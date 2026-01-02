package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class TheCelebrityProblem {
    //Approach - 1 - Using extra arrays, TC - O(N*N) + O(N) | SC - O(2N)
    class Solution {
        public int celebrity(int mat[][]) {
            // code here
            int n = mat.length;
            int[] knowMe = new int[n];
            int[] iKnow = new int[n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i != j && mat[i][j] == 1){
                        knowMe[j]++;
                        iKnow[i]++;
                    }
                }
            }
            for(int i=0; i<n; i++){
                // System.out.println("person = " + i+1 + " know by " + knowMe[i] + " knows = " + iKnow[i]);
                if(knowMe[i] == n-1 && iKnow[i] == 0){
                    return i;
                }
            }

            return -1;
        }
    }
    // 2 pointer Approach | TC - O(N) | SC O(1)
    class Solution {
        public int celebrity(int mat[][]) {

            int n = mat.length;

            // Two pointers representing potential celebrity candidates
            int top = 0, down = n - 1;

            // Step 1: Eliminate non-celebrities
            while (top < down) {

                // If top knows down, then top cannot be a celebrity
                if (mat[top][down] == 1) {
                    top++;
                }

                // If down knows top, then down cannot be a celebrity
                else if (mat[down][top] == 1) {
                    down--;
                }

                // If neither knows the other, both cannot be celebrities
                else {
                    top++;
                    down--;
                }
            }

            // If pointers crossed, no valid candidate exists
            if (top > down)
                return -1;

            // Step 2: Verify the potential celebrity
            for (int i = 0; i < n; i++) {

                // Skip self-check
                if (i == top) continue;

                // Celebrity condition:
                // 1. Celebrity knows nobody -> mat[top][i] == 0
                // 2. Everybody knows celebrity -> mat[i][top] == 1
                if (!(mat[top][i] == 0 && mat[i][top] == 1)) {
                    return -1;
                }
            }

            // Valid celebrity found
            return top;
        }
    }

}
