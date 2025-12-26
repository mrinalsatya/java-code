package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromPartitioning {
    class Solution {

        // This list will store all valid palindrome partitions
        List<List<String>> ans = new ArrayList<>();

        /**
         * Checks whether the substring s[l..r] is a palindrome
         * Uses two-pointer technique
         */
        public boolean isPalindrome(String s, int l, int r){
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }

        /**
         * Backtracking function to generate all palindrome partitions
         *
         * @param s     Input string
         * @param temp  Current partition being built
         * @param ind   Current starting index in string s
         */
        public void solve(String s, List<String> temp, int ind){
            // Base case: if we have reached the end of the string
            if(ind >= s.length()){
                // Add a deep copy of the current partition to answer
                ans.add(new ArrayList<>(temp));
                return;
            }

            // Try all possible substrings starting from index 'ind'
            for(int i = ind; i < s.length(); i++){
                // Check if s[ind..i] is a palindrome
                if(isPalindrome(s, ind, i)){
                    // Choose: add the palindrome substring
                    temp.add(s.substring(ind, i + 1));

                    // Explore further partitions from i+1
                    solve(s, temp, i + 1);

                    // Backtrack: remove the last added substring
                    temp.remove(temp.size() - 1);
                }
            }
        }

        /**
         * Main function to start palindrome partitioning
         */
        public List<List<String>> partition(String s) {
            solve(s, new ArrayList<>(), 0);
            return ans;
        }
    }

}
