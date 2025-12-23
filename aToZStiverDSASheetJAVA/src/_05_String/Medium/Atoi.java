package aToZStiverDSASheetJAVA.src._05_String.Medium;
//https://leetcode.com/problems/string-to-integer-atoi/
public class Atoi {
    class Solution {
        public int myAtoi(String s) {
            int n = s.length();

            // Step 1: Track the sign (+1 or -1)
            int sign = 1;

            // Step 2: Use long to detect overflow before returning int
            long result = 0;

            int i = 0;

            // Step 3: Skip all leading whitespace characters
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            // Step 4: Check for an optional '+' or '-' sign
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                sign = (s.charAt(i) == '+') ? 1 : -1;
                i++;
            }

            // Step 5: Process digits until a non-digit character appears
            while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int digit = s.charAt(i) - '0';   // Convert char to digit

                // Step 6: Build the number and check for overflow
                result = result * 10 + digit;

                // If sign is positive and result exceeds INT_MAX → clamp to INT_MAX
                if (sign == 1 && result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                // If sign is negative and -result exceeds INT_MIN → clamp to INT_MIN
                if (sign == -1 && -result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                i++;
            }

            // Step 7: Apply the sign and return as int
            return (int) result * sign;
        }
    }

}
