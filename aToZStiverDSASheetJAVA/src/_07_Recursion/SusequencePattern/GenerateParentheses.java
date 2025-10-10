package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

//https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    /*
  🧠 Explanation
  - open < n: we can still add '('
  - close < open: we can only add ')' if there’s an unmatched '('
  - stop when temp.length() == 2*n (we’ve used all parentheses)

  ⏱ Time Complexity
  - O(2ⁿ) worst case (all possible combinations)
  - O(Cₙ) valid combinations (Catalan number ≈ 4ⁿ / (n√n))
  - Each valid string has length 2n
  - So total ≈ O(4ⁿ / √n)
*/
    public void helper(int n, int open, int close, StringBuilder temp, List<String> ans){
        if(temp.length() == 2*n)
        {
            ans.add(temp.toString());
            return;
        }

        if(open < n){
            temp.append('(');
            helper(n, open+1, close, temp, ans);
            temp.setLength(temp.length() -1);
        }
        if(close < open){
            temp.append(')');
            helper(n, open, close+1, temp, ans);
            temp.setLength(temp.length() -1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int open = 0, close = 0; // if we don't use this we will be exploring the extra invalid combinations and will have to write isValid function at the end;
        helper(n, open, close, temp, ans);
        return ans;
    }
}
