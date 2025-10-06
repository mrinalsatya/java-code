package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumDLL;

public class DeleteAllOccOfX {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head == null)
            return head;
        Node temp = head;

        //if key is at head
        while(temp != null && temp.data == x){
            head = temp.next;
            if(head != null) head.prev = null;
            temp = head;
        }

        //delete other occurences
        while(temp != null){
            if(temp.data == x){
                Node prev = temp.prev;
                Node next = temp.next;

                if(prev != null) prev.next = next;
                if(next != null) next.prev = prev;
            }
            temp = temp.next;
        }

        return head;
    }
}
