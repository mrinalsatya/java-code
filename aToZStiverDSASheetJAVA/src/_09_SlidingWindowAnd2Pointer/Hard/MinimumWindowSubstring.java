package aToZStiverDSASheetJAVA.src._09_SlidingWindowAnd2Pointer.Hard;
//https://leetcode.com/problems/minimum-window-substring/description/
//Time Complexity: O(n)
//
//Space Complexity: O(|t|)
public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {

            int n = s.length();
            int m = t.length();

            // Left and right pointers for sliding window
            int l = 0, r = 0;

            // Count of characters matched so far
            int cnt = 0;

            // Minimum window length found
            int minLen = Integer.MAX_VALUE;

            // Starting index of the minimum window
            int startInd = -1;

            // Frequency map for characters in t
            Map<Character, Integer> mp = new HashMap<>();
            for (char ch : t.toCharArray()) {
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            }

            // Expand window using right pointer
            while (r < n) {

                char ch = s.charAt(r);

                // If character is needed, decrement its count
                if (mp.containsKey(ch)) {
                    if (mp.get(ch) > 0) {
                        cnt++;
                    }
                    mp.put(ch, mp.get(ch) - 1);
                }

                // When all characters of t are matched
                while (cnt == m) {

                    // Update minimum window
                    if (r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        startInd = l;
                    }

                    char leftChar = s.charAt(l);

                    // Shrink window from the left
                    if (mp.containsKey(leftChar)) {
                        mp.put(leftChar, mp.get(leftChar) + 1);

                        // If a required character is lost, decrease count
                        if (mp.get(leftChar) > 0) {
                            cnt--;
                        }
                    }

                    l++;
                }

                r++;
            }

            // If no valid window found, return empty string
            return startInd == -1 ? "" : s.substring(startInd, startInd + minLen);
        }
    }

}
