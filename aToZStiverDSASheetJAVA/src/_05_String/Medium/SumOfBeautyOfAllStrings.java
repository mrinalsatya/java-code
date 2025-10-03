package aToZStiverDSASheetJAVA.src._05_String.Medium;
/*
Brute Force (O(n³))
1. Generate all substrings (O(n²)).
2. For each substring, compute char frequencies (O(n)).
3. Find max freq and min freq among >0 counts.
4. Add difference to result.
But this is too slow (n ≤ 500 → O(n³) = 125M ops).
 */

//Optimized Approach (O(n² * 26))
public class SumOfBeautyOfAllStrings {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i< n; i++){
            int[] freq = new int[26];

            for(int j = i; j <n ;j++){
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                int maxLen = 0;
                int minLen = Integer.MAX_VALUE;

                for(int num : freq){
                    if(num > 0){
                        maxLen = Math.max(maxLen, num);
                        minLen = Math.min(minLen, num);
                    }
                }
                ans += (maxLen - minLen);
            }

        }

        return ans;
    }
}
