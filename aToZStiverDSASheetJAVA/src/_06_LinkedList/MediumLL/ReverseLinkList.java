package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class ReverseLinkList {
    // Recursive Approach
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null)
//            return head;
//        ListNode ans = new ListNode(0);
//        ans.next = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return ans.next;
//    }

    //Iterative Approach
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
