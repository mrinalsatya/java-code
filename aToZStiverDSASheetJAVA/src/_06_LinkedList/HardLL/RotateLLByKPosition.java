package aToZStiverDSASheetJAVA.src._06_LinkedList.HardLL;

public class RotateLLByKPosition {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        ListNode temp = head;
        int len = 1;
        // Step 1: find length and last node
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        // Step 2: make it circular
        temp.next = head;
        // Step 3: compute effective rotation
        k = k%len;
        int steps = len-k-1;
        ListNode nextNode = null;
        temp = head;
        // Step 4: move to new tail
        while(steps > 0){
            temp = temp.next;
            steps--;
        }
        // Step 5: set new head and break the circle
        nextNode = temp.next;
        temp.next = null;

        return nextNode;
    }
}
