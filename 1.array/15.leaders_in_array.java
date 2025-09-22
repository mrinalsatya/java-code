class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int maxEl = arr[n-1];
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(maxEl);
        
        for(int i = n-2; i>=0; i--){
            if(arr[i] >= maxEl){
                ans.add(arr[i]);
                maxEl = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
        
    }
}