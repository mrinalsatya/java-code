package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

import aToZStiverDSASheetJAVA.src._06_LinkedList.Node;

public class SortZeroOneTwo {
    public Node segregate(Node head) {
        // code here
        if(head == null || head.next == null)
            return head;
        Node dummyZero = new Node(-1);
        Node dummyOne = new Node(-1);
        Node dummyTwo = new Node(-1);
        Node temp = head;
        Node tempZero = dummyZero;
        Node tempOne = dummyOne;
        Node tempTwo = dummyTwo;

        while(temp!= null){
            if(temp.data == 0){
                tempZero.next = temp;
                tempZero = temp;
            }
            else if(temp.data == 1){
                tempOne.next = temp;
                tempOne = temp;
            }
            else{
                tempTwo.next = temp;
                tempTwo = temp;
            }

            temp = temp.next;
        }

        tempZero.next = dummyOne.next != null ? dummyOne.next : dummyTwo.next;
        tempOne.next = dummyTwo.next;
        tempTwo.next = null;
        Node newHead = dummyZero.next;
        return newHead;



    }
}
