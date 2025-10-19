package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class ImplementStackUsingQueue {
    Queue<Integer> q = new LinkedList<>();
    public ImplementStackUsingQueue() {

    }

    public void push(int x) {
        q.offer(x);
        int n = q.size();

        for(int i =0; i<n-1; i++){
            q.offer(q.peek());
            q.poll();
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
