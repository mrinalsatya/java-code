package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;
//https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class NearestSmallerToLeft {
    class Solution {
        public int[] leftSmaller(int[] arr) {
            // code here
            int n = arr.length;
            int[] ans = new int[n];
            Stack<Integer> st = new Stack<>();

            for(int i =0; i< n; i++){
                while(!st.isEmpty() && st.peek() >= arr[i]){
                    st.pop();
                }

                ans[i] = st.isEmpty() ? -1 : st.peek();

                st.push(arr[i]);
            }

            return ans;
        }
    }

}
