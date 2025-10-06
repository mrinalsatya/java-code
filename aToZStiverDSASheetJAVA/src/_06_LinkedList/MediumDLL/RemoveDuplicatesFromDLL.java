package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumDLL;

public class RemoveDuplicatesFromDLL {
    Node removeDuplicates(Node head) {
        // Code Here.
        if(head == null || head.next == null)
            return head;
        Node temp = head;
        while(temp != null){
            Node nextNode = temp.next;
            while(nextNode != null && nextNode.data == temp.data) nextNode = nextNode.next;
            temp.next = nextNode;
            if(nextNode != null) nextNode.prev = temp;
            temp = nextNode;
        }

        return head;
    }
}
