package _05_String.Easy;

public class RemoveOuterMostParenthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                if(count > 0){
                    ans.append(c); // push when there is already existing opening parenthesis
                }
                count++;
            }
            else{
                count--;
                if(count > 0){
                    ans.append(c); // in case of closing parenthesis ')' if after decresing the '(' count it becomes 0 then it means it was outermost parenthesis so don't add. Only add if it is > 0;
                }
            }
        }

        return ans.toString();
    }
}
