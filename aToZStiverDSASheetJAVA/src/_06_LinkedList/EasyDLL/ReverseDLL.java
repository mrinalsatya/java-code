package aToZStiverDSASheetJAVA.src._06_LinkedList.EasyDLL;

import aToZStiverDSASheetJAVA.src._06_LinkedList.Node;

public class ReverseDLL {
    public Node reverse(Node head) {
        // code here
        if(head == null || head.next == null)
            return head;
        Node temp = null;
        Node curr = head;
        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        return temp.prev;
    }
}
