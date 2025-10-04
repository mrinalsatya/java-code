package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class RemoveNthNodeFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        //if n == lenght of list
        if(fast==null)
            return head.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
