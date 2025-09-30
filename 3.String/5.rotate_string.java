//optimal solution - O(n)
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        StringBuilder str = new StringBuilder(s);
        int n = s.length();
        while(true){
            if(str.toString().equals(goal))
                return true;
            char ch = str.charAt(0);
            str.deleteCharAt(0);
            str.append(ch);
            n--;
            if(n == 0 && !str.toString().equals(goal))  break;
        }

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