package aToZStiverDSASheetJAVA.src._09_SlidingWindowAnd2Pointer.Medium;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// TC - O(N) | SC - O(min(n,26))
public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            // Stores the maximum length found
            int maxLen = 0;

            // Left and right pointers of sliding window
            int l = 0, r = 0;

            // Map to store the last index of each character
            Map<Character, Integer> mp = new HashMap<>();

            // Expand the window using right pointer
            while (r < s.length()) {

                char ch = s.charAt(r);

                // If character already exists in map,
                // move left pointer to avoid duplicate
                if (mp.containsKey(ch)) {
                    // IMPORTANT: take max to avoid moving left backwards
                    l = Math.max(l, mp.get(ch) + 1);
                }

                // Update last seen index of character
                mp.put(ch, r);

                // Update maximum length of valid window
                maxLen = Math.max(maxLen, r - l + 1);

                // Move right pointer forward
                r++;
            }

            return maxLen;
        }
    }

}
