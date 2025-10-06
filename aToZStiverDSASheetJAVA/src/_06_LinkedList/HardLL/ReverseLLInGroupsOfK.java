package aToZStiverDSASheetJAVA.src._06_LinkedList.HardLL;

public class ReverseLLInGroupsOfK {
    public static ListNode findKthNode(ListNode temp, int k){
        ListNode kthNode = temp;
        for(int i = 1; i<k ; i++){
            if(kthNode == null)
                break;
            kthNode = kthNode.next;
        }

        return kthNode;
    }
    public static ListNode reverseLL(ListNode head){
        if(head == null || head.next == null)
            return head;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);
            if(temp == head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}
