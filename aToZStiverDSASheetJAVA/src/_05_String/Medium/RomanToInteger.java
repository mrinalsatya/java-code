package aToZStiverDSASheetJAVA.src._05_String.Medium;
//https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {
    class Solution {

        public int romanToInt(String s) {

            // Map each Roman symbol to its integer value
            HashMap<Character, Integer> symbol = new HashMap<>();
            symbol.put('I', 1);
            symbol.put('V', 5);
            symbol.put('X', 10);
            symbol.put('L', 50);
            symbol.put('C', 100);
            symbol.put('D', 500);
            symbol.put('M', 1000);

            int ans = 0;
            int n = s.length();

        /*
            Roman numeral rule:
            - Normally, values are added.
            - But if a smaller value appears BEFORE a larger value,
              it means subtraction (e.g., IV = 4, IX = 9).

            So we do this:
            For each character s[i]:
                - If its value < next character's value → subtract it.
                - Otherwise → add it.
        */

            for (int i = 0; i < n; i++) {

                // Value of current Roman symbol
                int currVal = symbol.get(s.charAt(i));

                // Check if next symbol exists AND is larger
                if (i < n - 1 && currVal < symbol.get(s.charAt(i + 1))) {
                    // Subtract if a smaller value precedes a larger one
                    ans -= currVal;
                } else {
                    // Otherwise, add normally
                    ans += currVal;
                }
            }

            return ans;
        }
    }

}
