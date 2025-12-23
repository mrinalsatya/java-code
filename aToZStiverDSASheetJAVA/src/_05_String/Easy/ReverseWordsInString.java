package aToZStiverDSASheetJAVA.src._05_String.Easy;
//https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordsInString {
    class Solution {
        public String reverseWords(String s) {
            //s.trim() removes leading & trailing spaces.
            //.split("\\s+") splits by 1 or more spaces.
            // What is \\s+
       /*
        * This is a regex pattern:
        \s → means whitespace character (space, tab, newline, etc).
        + → means one or more occurrences of the previous symbol.
        So, \s+ = "one or more whitespace characters".
        */
            String[] words = s.trim().split("\\s+");
            StringBuilder ans = new StringBuilder();
            for(int i= words.length-1; i>=0; i--){
                ans.append(words[i]);
                if(i != 0) ans.append(" ");
            }

            return ans.toString();
        }
    }

    // Better Approach - 2 pointer
    class Solution {
        public String reverseWords(String s) {
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            int n = s.length();
            for(int i = n - 1; i>= 0; i--){
                char ch = s.charAt(i);
                if(ch != ' '){
                    temp.append(ch);
                }
                else{
                    if(temp.length() > 0){
                        if(result.length() > 0){
                            result.append(" ");
                        }
                        result.append(temp.reverse());
                        temp.setLength(0);
                    }
                }
            }

            if(temp.length() > 0){
                if(result.length() > 0){
                    result.append(" ");
                }

                result.append(temp.reverse());
            }
            return result.toString();
        }
    }
}
