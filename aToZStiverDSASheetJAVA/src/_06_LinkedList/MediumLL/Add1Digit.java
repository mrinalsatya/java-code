package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class Add1Digit {
    public static Node reverseLL(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        head = reverseLL(head);
        Node temp = head;
        Node prev = null;
        int carry = 1;
        while(temp != null){
            int sum = temp.data + carry;
            carry = sum/10;
            temp.data = sum%10;
            if(carry == 0)
                break;
            prev = temp;
            temp = temp.next;
        }
        if(carry > 0)
            prev.next = new Node(carry);

        return reverseLL(head);
    }
}
