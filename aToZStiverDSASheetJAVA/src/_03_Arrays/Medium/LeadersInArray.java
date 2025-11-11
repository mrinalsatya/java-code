package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;

public class LeadersInArray {
    class Solution {
        static ArrayList<Integer> leaders(int arr[]) {
            // code here
            int maxNum = Integer.MIN_VALUE;
            int n = arr.length;
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = n-1; i>=0; i--){
                if(arr[i] >= maxNum){
                    ans.add(arr[i]);
                    maxNum = arr[i];
                }
            }

            Collections.reverse(ans);
            return ans;
        }
    }

}
