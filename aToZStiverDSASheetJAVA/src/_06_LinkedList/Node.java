package aToZStiverDSASheetJAVA.src._06_LinkedList;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        return;
    }

    public static Node insertNode(int key, Node head){
        Node temp = head;
        Node newNode = new Node(key);
        if(head == null){
            return newNode;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static int lengthOfLL(Node head){
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}
