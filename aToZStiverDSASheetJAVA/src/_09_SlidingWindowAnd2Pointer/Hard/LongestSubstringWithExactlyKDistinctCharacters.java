package aToZStiverDSASheetJAVA.src._09_SlidingWindowAnd2Pointer.Hard;
//https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
/*Time Complexity: O(n)

Space Complexity: O(k) → at most k distinct characters in map

 */
public class LongestSubstringWithExactlyKDistinctCharacters {
    class Solution {
        public int longestKSubstr(String s, int k) {

            int n = s.length();

            // Left and right pointers for sliding window
            int l = 0, r = 0;

            // Stores the maximum length of valid substring
            // Initialized to -1 (required by problem statement)
            int maxLen = -1;

            // HashMap to store frequency of characters in current window
            Map<Character, Integer> mp = new HashMap<>();

            // Expand window using right pointer
            while (r < n) {

                // Add current character to map or increment its count
                char ch = s.charAt(r);
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);

                // If number of distinct characters exceeds k,
                // shrink window from the left
                if (mp.size() > k) {

                    // Decrease count of left character
                    char leftChar = s.charAt(l);
                    mp.put(leftChar, mp.get(leftChar) - 1);

                    // Remove character from map if its count becomes zero
                    if (mp.get(leftChar) == 0) {
                        mp.remove(leftChar);
                    }

                    // Move left pointer forward
                    l++;
                }

                // If window contains exactly k distinct characters,
                // update maximum length
                if (mp.size() == k) {
                    maxLen = Math.max(maxLen, r - l + 1);
                }

                // Move right pointer forward
                r++;
            }

            return maxLen;
        }
    }

}
