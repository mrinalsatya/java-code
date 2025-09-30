//optimal solution - O(n)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] s1 = new char[256];
        char[] t1 = new char[256];
        if(s.length() != t.length())
            return false;
        int n = s.length();

        for(int i = 0; i<n; i++){
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if(s1[sCh] == 0 && t1[tCh] == 0){
                s1[sCh] = tCh;
                t1[tCh] = sCh;
            }
            else{
                if(s1[sCh] != tCh  || t1[tCh ] != sCh )
                    return false;
            }
        }

        return true;
    }
}