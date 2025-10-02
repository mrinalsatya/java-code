package _05_String.Medium;

public class LongestPalindromicSubstring {
    //Extreme bruteforce O(n3) - generate all substring(O(n2)) and check for palindrome O(n)
    public boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;

        }

        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        StringBuilder curr = new StringBuilder();

        for(int i = 0; i< n; i++){
            curr.setLength(0);
            for(int j = i; j<n; j++){
                curr.append(s.charAt(j));
                if(ans.length() >= curr.length()) // you can skip checking if the current string has less than or equal len of answer
                    continue;
                if(isPalindrome(curr.toString()))
                {
                    if(curr.length() > ans.length()){
                        ans = curr.toString();
                    }
                }
            }
        }

        return ans;
    }

    //Better Solution O(n2) - Expand center search

    public int[] expandSearch(String s, int n, int left, int right){
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }

        return new int[]{left+1, right-left-1};
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        int start = 0;
        int len = 0;

        for(int i =0; i< n; i++){
            int[] odd = expandSearch(s, n, i, i); // for odd
            int[] even = expandSearch(s, n, i, i+1); // for even like "aa"

            if(odd[1] > len){
                len = odd[1];
                start = odd[0];
            }
            if(even[1] > len){
                len = even[1];
                start = even[0];
            }
        }

        return s.substring(start, start+len);
    }
}
