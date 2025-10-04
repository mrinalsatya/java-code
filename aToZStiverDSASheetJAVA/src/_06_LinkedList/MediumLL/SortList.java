package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class SortList {
    public static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode mergeList(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        while(l1 != null){
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while(l2 != null){
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }

        return dummyNode.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        head = sortList(head);
        rightHead = sortList(rightHead);
        head = mergeList(head, rightHead);
        return head;
    }
}
