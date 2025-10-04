package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class DetectCycleLength {
    public int lengthOfLoop(Node head) {
        // code here

        if(head == null || head.next == null)
            return 0;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = fast.next;
                int cnt = 1;
                while(slow != fast){
                    cnt++;
                    fast = fast.next;
                }
                return cnt;
            }
        }

        return 0;
    }
}
