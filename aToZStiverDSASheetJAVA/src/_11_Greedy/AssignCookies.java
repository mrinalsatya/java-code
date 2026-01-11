package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://leetcode.com/problems/assign-cookies/
/*
Key Interview Explanation - Uses a greedy strategy
 - Always tries to satisfy the least greedy child first
 - Assigns the smallest possible cookie that works
 - Larger cookies are saved for greedier children

⏱️ Complexity (Optimal) | TC: O(n log n + m log m) | SC: O(1) (excluding sort internals)
 */
public class AssignCookies {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {

            // Sort greed factors of children
            Arrays.sort(g);

            // Sort sizes of cookies
            Arrays.sort(s);

            int n = g.length; // number of children
            int m = s.length; // number of cookies

            // r -> index for children
            // l -> index for cookies
            int r = 0, l = 0;

            // Traverse cookies one by one
            while (l < m) {

                // If current cookie can satisfy current child
                if (r < n && g[r] <= s[l]) {
                    // Assign cookie to child
                    r++;
                }

                // Move to next cookie (used or not)
                l++;
            }

            // r represents the number of children who got cookies
            return r;

        }
    }
}
