package aToZStiverDSASheetJAVA.src._07_Recursion.Basics;

public class CheckPalindrome {
    public static boolean checkPalindrome(char[] c, int l, int r){
        if(l > r)
            return true;
        if(c[l] != c[r]) return false;
        return checkPalindrome(c, l+1, r-1);
    }

    public static void main(String[] args) {
        String a = "aibohphobia";
        System.out.println(a + " is Palindrome = " + checkPalindrome(a.toCharArray(), 0 , a.length()-1));
        String b = "mrinal";
        System.out.println(b + " is Palindrome = " + checkPalindrome(b.toCharArray(), 0 , b.length()-1));
    }
}
