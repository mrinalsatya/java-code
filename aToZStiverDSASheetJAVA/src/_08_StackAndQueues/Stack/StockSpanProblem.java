package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;
//link - https://leetcode.com/problems/online-stock-span/
public class StockSpanProblem {
    class StockSpanner {
        /**
         * Pair stores:
         * val   -> stock price
         * index -> span count for that price
         */
        class Pair {
            int val, index;

            Pair(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }

        // for array
        public ArrayList<Integer> calculateSpan(int[] nums) {
            ArrayList<Integer> ans = new ArrayList<>();
            Stack<Integer> st = new Stack<>();

            for(int i=0; i<nums.length; i++){
                while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans.add(i+1);
                }else{
                    ans.add(i-st.peek());
                }
                st.push(i);
            }

            return ans;
        }


        // Monotonic decreasing stack (stores Pair objects)
        Stack<Pair> st = new Stack<>();

        public StockSpanner() {
            // Stack initialized empty
        }

        /**
         * Returns the stock span for today's price.
         */
        public int next(int price) {

            // At least one day (today itself)
            int cnt = 1;

            // Pop all prices smaller than or equal to current price
            // and accumulate their span values
            while (!st.isEmpty() && st.peek().val <= price) {
                cnt += st.peek().index;
                st.pop();
            }

            // Push current price with its calculated span
            st.push(new Pair(price, cnt));

            return cnt;
        }
    }

}
