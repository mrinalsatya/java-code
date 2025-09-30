// Naive Approach - O(nlogn)

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }
}


//Optimal Solution O(n)

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] frequency = new int[26];
        for(char ch : s.toCharArray()) frequency[ch - 'a']++;
        for(char ch : t.toCharArray()) frequency[ch - 'a']--;

        for(int count : frequency){
            if(count != 0) return false;
        }

        return true;
    }
}