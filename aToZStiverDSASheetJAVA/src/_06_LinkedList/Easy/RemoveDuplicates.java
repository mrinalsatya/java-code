package aToZStiverDSASheetJAVA.src._06_LinkedList.Easy;

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        while(temp != null){
            ListNode nextNode = temp.next;
            while(nextNode != null && temp.val == nextNode.val) nextNode = nextNode.next;
            temp.next = nextNode;
            temp = nextNode;
        }

        return head;
    }
}
