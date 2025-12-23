package aToZStiverDSASheetJAVA.src._05_String.Easy;
//https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {

            // If lengths differ, cannot be isomorphic
            if (s.length() != t.length())
                return false;

            int n = s.length();

            // These arrays store mapping of characters.
            // s1[ch] = what 'ch' in s maps to in t
            // t1[ch] = what 'ch' in t maps to in s (reverse mapping)
            // Size 256 because extended ASCII (safe for any testcases)
            char[] s1 = new char[256];
            char[] t1 = new char[256];

            for (int i = 0; i < n; i++) {

                char sCh = s.charAt(i);   // char from s
                char tCh = t.charAt(i);   // corresponding char from t

                // Case 1: Neither character has been mapped before.
                // So we create a new mapping.
                if (s1[sCh] == 0 && t1[tCh] == 0) {
                    s1[sCh] = tCh;  // map s → t
                    t1[tCh] = sCh;  // map t → s (reverse check)
                }

                // Case 2: Mapping already exists → must match current pair
                else {
                    // If expected mapping doesn't match → not isomorphic
                    if (s1[sCh] != tCh || t1[tCh] != sCh)
                        return false;
                }
            }

            // All characters mapped correctly
            return true;
        }
    }

}
