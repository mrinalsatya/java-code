package aToZStiverDSASheetJAVA.src._09_SlidingWindowAnd2Pointer.Medium;
//https://leetcode.com/problems/fruit-into-baskets/
//Time Complexity: O(n)
//Space Complexity: O(1) (map size ≤ 2)

public class FruitsIntoBaskets {
    class Solution {
        public int totalFruit(int[] fruits) {

            int n = fruits.length;

            // Left and right pointers of the sliding window
            int l = 0, r = 0;

            // Stores the maximum number of fruits collected
            int maxLen = 0;

            // HashMap to store count of each fruit type in the current window
            Map<Integer, Integer> mp = new HashMap<>();

            // Expand the window using the right pointer
            while (r < n) {

                // Add current fruit to the map (increase its count)
                mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1);

                // If more than 2 fruit types are present,
                // shrink the window from the left
                if (mp.size() > 2) {

                    // Decrease count of the fruit at the left pointer
                    mp.put(fruits[l], mp.get(fruits[l]) - 1);

                    // Remove fruit type if its count becomes zero
                    if (mp.get(fruits[l]) == 0) {
                        mp.remove(fruits[l]);
                    }

                    // Move left pointer forward
                    l++;
                }

                // If window has at most 2 fruit types,
                // update the maximum length
                if (mp.size() <= 2) {
                    maxLen = Math.max(maxLen, r - l + 1);
                }

                // Move right pointer forward
                r++;
            }

            return maxLen;
        }
    }

}
