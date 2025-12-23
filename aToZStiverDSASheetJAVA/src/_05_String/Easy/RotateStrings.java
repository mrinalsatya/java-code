package aToZStiverDSASheetJAVA.src._05_String.Easy;
//https://leetcode.com/problems/rotate-string/description/
public class RotateStrings {
    //optimal solution - O(n2)
    class Solution {
        public boolean rotateString(String s, String goal) {

            // If lengths differ, rotation is impossible
            if (s.length() != goal.length())
                return false;

            // Use StringBuilder to perform rotations efficiently
            StringBuilder str = new StringBuilder(s);
            int n = s.length();   // Number of possible rotations

            while (true) {

                // Check if current rotation matches goal
                if (str.toString().equals(goal))
                    return true;

                // Rotate left by 1 character:
                // take first char -> remove it -> append it to end
                char ch = str.charAt(0);
                str.deleteCharAt(0);
                str.append(ch);

                n--;  // One rotation done

                // If all rotations tried and still no match, stop
                if (n == 0 && !str.toString().equals(goal))
                    break;
            }

            // Final check (usually unnecessary due to loop, but kept safely)
            return str.toString().equals(goal);
        }
    }


//Alternative O(n) Solution

    class Solution {
        public boolean rotateString(String s, String goal) {
            // Lengths must match, otherwise impossible
            if (s.length() != goal.length()) return false;

            // Check if goal is inside s+s
            return (s + s).contains(goal);
        }
    }

// O(n2) Solution (Manual rotation check)

    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) return false;

            for (int i = 0; i < s.length(); i++) {
                String rotated = s.substring(i) + s.substring(0, i);
                if (rotated.equals(goal)) return true;
            }
            return false;
        }
    }
}
