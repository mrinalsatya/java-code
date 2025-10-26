package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                char top = st.pop();
                if((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '['))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
