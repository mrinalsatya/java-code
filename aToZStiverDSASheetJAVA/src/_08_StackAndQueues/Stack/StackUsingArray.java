package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;
class Stack{
    int[] nums = new int[10];
    int ind = -1;

    public void push(int x){
        if(ind+1 == nums.length){
            System.out.println("Stack is full");
        }
        else{
            nums[ind+1] = x;
            ind++;
        }
    }

    public int top(){
        if(ind == -1){
            System.out.println("Stack is empty");
            return -1;
        }

        return nums[ind];
    }

    public int size(){
        return ind+1;
    }

    public int pop(){
        if(ind == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        int temp = nums[ind];
        nums[ind] = 0;
        ind--;
        return temp;
    }

    public boolean isEmpty(){
        return  ind == -1;
    }

}

class StackLL{
    StackLL next;
    int val;

    StackLL(int val){
        this.val = val;
        this.next = null;
    }

    public StackLL push(int x, StackLL top){
        StackLL node = new StackLL(x);
        node.next = top;
        top = node;
        return top;
    }

    public StackLL pop(StackLL top){
        StackLL node = top;

        top = top.next;
        node.next = null;
        return top;
    }

}
public class StackUsingArray {
    public static void main(String[] args) {

        Stack st = new Stack();
        System.out.println("Size of Stack is: " + st.size());
        st.push(1);
        st.push(2);
        System.out.println("Size of Stack is: " + st.size());
        System.out.println("top element in stack is: " + st.top());
        st.push(3);
        System.out.println("top element in stack is: " + st.top());

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

        System.out.println("top element in stack is: " + st.top());

        System.out.println(st.isEmpty());

    }
}
