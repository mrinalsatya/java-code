// Best solution : Time complexity O(N) and Space is O(1)

class Solution {
    public String largestOddNumber(String num) {
        int ind = num.length() - 1;
        while(ind >= 0){
            int digit = num.charAt(ind) - '0';
            if(digit%2 == 1){
                return num.substring(0, ind+1);
            }
            ind--;
        }

        return "";
    }
}