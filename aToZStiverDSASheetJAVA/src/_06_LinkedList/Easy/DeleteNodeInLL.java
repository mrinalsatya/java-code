package aToZStiverDSASheetJAVA.src._06_LinkedList.Easy;

import aToZStiverDSASheetJAVA.src._06_LinkedList.Node;

public class DeleteNodeInLL {
    public static Node deleteHead(Node head){
        if(head == null){
            return head;
        }
        return head.next;
    }

    public static Node deleteAtTail(Node head){
        if(head == null)
            return null;
        Node temp = head;
        while(temp.next != null && temp.next.next !=null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static void deleteWithoutHead(Node node){
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
        temp.next = null;
    }

    public static Node deleteKthNode(Node head, int k){
        if(k==0 || head==null)
                return head;
        if(k==1)
            return head.next;
        Node prev = null;
        Node temp = head;
        int cnt = 1;
        while(cnt < k && temp.next != null){
            prev = temp;
            temp = temp.next;
            cnt++;
        }

        if(cnt < k)
            return head;
        prev.next = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = Node.insertNode(2, head);
        head = Node.insertNode(3, head);
        head = Node.insertNode(4, head);
        head = Node.insertNode(5, head);

        Node.printLL(head);
        head = deleteHead(head);
        head = deleteAtTail(head);
        Node.printLL(head);
        deleteWithoutHead(head.next.next);


    }
}
