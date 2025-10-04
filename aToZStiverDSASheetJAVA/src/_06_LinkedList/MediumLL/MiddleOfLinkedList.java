package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

import aToZStiverDSASheetJAVA.src._06_LinkedList.Node;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow;
        ListNode fast;
        slow = head;
        fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
