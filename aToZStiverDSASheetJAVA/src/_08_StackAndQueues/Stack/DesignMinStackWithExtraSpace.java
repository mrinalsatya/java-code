package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class DesignMinStackWithExtraSpace {
    //Using pair
    class MinStack {
        class Pair{
            int first, second;
            Pair(int first, int second){
                this.first = first;
                this.second = second;
            }
        }

        Deque<Pair> st = new ArrayDeque<>();
        public MinStack() {

        }

        public void push(int val) {
            int min;
            if(st.isEmpty()){
                min = val;
            }else{
                min = Math.min(val, st.peek().second);
            }
            st.push(new Pair(val, min));
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek().first;
        }

        public int getMin() {
            return st.peek().second;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
