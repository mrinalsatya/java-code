package aToZStiverDSASheetJAVA.src._06_LinkedList.Easy;

import aToZStiverDSASheetJAVA.src._06_LinkedList.Node;

public class LinearSearchInLL {
    public boolean searchKey(int key, Node head){
        Node temp = head;
        while(temp != null){
            if(temp.data == key)
                return true;
            temp = temp.next;
        }

        return false;
    }
}
