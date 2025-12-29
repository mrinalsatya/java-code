package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class TrappingRainWaterProblem {
    //Prefix sum, suffix summ approach, with additional space
    //TC - O(N), SC - O(N)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int total = 0;
            int[] prefMax = new int[n];
            int[] suffMax = new int[n];
            prefMax[0] = height[0];
            suffMax[n-1] = height[n-1];
            for(int i=1; i< n; i++){
                prefMax[i] = Math.max(prefMax[i-1], height[i]);
            }

            for(int i = n-2; i>= 0; i--){
                suffMax[i] = Math.max(suffMax[i+1], height[i]);
            }

            for(int i = 0; i < n; i++){
                if(height[i] < prefMax[i] && height[i] < suffMax[i]){
                    total += Math.min(prefMax[i], suffMax[i]) - height[i];
                }
            }

            return total;
        }
    }
    // 2pointer approach, TC - O(N), SC - O(1)
    class Solution {
        public int trap(int[] height) {

            // Number of bars in the elevation map
            int n = height.length;

            // Two pointers: left and right
            int l = 0, r = n - 1;

            // To store maximum height seen so far from left and right
            int lMax = 0, rMax = 0;

            // Total trapped rain water
            int sum = 0;

            // Process bars until both pointers meet
            while (l < r) {

                // Compare heights at left and right pointers
                if (height[l] <= height[r]) {

                    // If current left bar is lower than max seen so far,
                    // water can be trapped on top of it
                    if (height[l] < lMax) {
                        sum += lMax - height[l];
                    } else {
                        // Update left maximum height
                        lMax = height[l];
                    }

                    // Move left pointer inward
                    l++;

                } else {

                    // If current right bar is lower than max seen so far,
                    // water can be trapped on top of it
                    if (height[r] < rMax) {
                        sum += rMax - height[r];
                    } else {
                        // Update right maximum height
                        rMax = height[r];
                    }

                    // Move right pointer inward
                    r--;
                }
            }

            // Return total trapped water
            return sum;
        }
    }

}
