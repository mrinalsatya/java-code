package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

//https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
public class NextSmallerToRight {
    class Solution {
        static ArrayList<Integer> nextSmallerEle(int[] arr) {
            // code here

            ArrayList<Integer> ans = new ArrayList<>();

            Deque<Integer> st = new ArrayDeque<>();

            for(int i = arr.length - 1; i >= 0; i--){
                while(!st.isEmpty() && st.peek() >= arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    ans.add(-1);
                }else{
                    ans.add(st.peek());
                }

                st.push(arr[i]);
            }

            Collections.reverse(ans);

            return ans;

        }
    }
}
