package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class RemoveKDigits {
    class Solution {
        public String removeKdigits(String num, int k) {

            Deque<Character> st = new ArrayDeque<>();

            for (char ch : num.toCharArray()) {
                // Remove larger digits to minimize the number
                while (k > 0 && !st.isEmpty() && st.peek() > ch) {
                    st.pop();
                    k--;
                }
                st.push(ch);
            }

            // If removals still left, remove from end
            while (k > 0) {
                st.pop();
                k--;
            }

            // Build result
            StringBuilder ans = new StringBuilder();
            while (!st.isEmpty()) {
                ans.append(st.pop());
            }
            ans.reverse();

            // Remove leading zeros
            while (ans.length() > 1 && ans.charAt(0) == '0') {
                ans.deleteCharAt(0);
            }

            return ans.length() == 0 ? "0" : ans.toString();
        }
    }
}
