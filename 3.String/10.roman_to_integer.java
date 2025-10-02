class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> symbol = new HashMap<>();
        symbol.put('I', 1);
        symbol.put('V', 5);
        symbol.put('X', 10);
        symbol.put('L', 50);
        symbol.put('C', 100);
        symbol.put('D', 500);
        symbol.put('M', 1000);
        int ans = 0, n = s.length();
        for(int i=0; i<n;i++){
            int num = symbol.get(s.charAt(i));
            if(i < n-1 && num < symbol.get(s.charAt(i+1))){
                ans -= num; // if current number is less than the next number
            }
            else{
                ans += num; // if it is greater
            }
        }

        return ans;
    }
}