package aToZStiverDSASheetJAVA.src._09_SlidingWindowAnd2Pointer.Medium;
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
/*
You must take exactly k cards from either end

Instead of checking all combinations, we:

Start by taking all k cards from the left

Then slide the selection by:

Removing one card from the left

Adding one card from the right

This efficiently explores all valid possibilities

TC - O(k) | Sc - O(1)
 */
public class MaximumPointsYouCanObtainFromCards {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {

            int n = cardPoints.length;

            // Sum of cards taken from the left side
            int leftSum = 0;

            // Sum of cards taken from the right side
            int rightSum = 0;

            // Maximum score obtainable
            int maxSum = 0;

            // Pointer to the right end of the array
            int rightInd = n - 1;

            // Step 1: Take all k cards from the left initially
            for (int i = 0; i < k; i++) {
                leftSum += cardPoints[i];
            }

            // Initialize maxSum with the case of taking all cards from left
            maxSum = leftSum;

            // Step 2: Gradually replace cards taken from left with cards from right
            // i goes from k-1 down to 0 (number of cards taken from left decreases)
            for (int i = k - 1; i >= 0; i--) {

                // Remove one card from left side
                leftSum -= cardPoints[i];

                // Add one card from right side
                rightSum += cardPoints[rightInd];
                rightInd--;

                // Update maximum score
                maxSum = Math.max(maxSum, leftSum + rightSum);
            }

            return maxSum;
        }
    }

}
