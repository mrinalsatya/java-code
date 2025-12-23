package aToZStiverDSASheetJAVA.src._05_String.Medium;
//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
public class MaximumNestingDepthOfParentheses {
    class Solution {
        public int maxDepth(String s) {
            int maxCount = 0, currCount = 0, n = s.length();
            for(int i = 0;i < n; i++){
                if(s.charAt(i) == '('){
                    currCount++;
                    maxCount = Math.max(currCount, maxCount);
                }else if(s.charAt(i) == ')'){
                    currCount--;
                }
            }

            return maxCount;
        }
    }
}
