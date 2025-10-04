package aToZStiverDSASheetJAVA.src._06_LinkedList.Easy;
import aToZStiverDSASheetJAVA.src._06_LinkedList.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SinglyLinkedListOperations {
    public static Node makeLLfromArr(ArrayList<Integer> nums){
        Node dummy = new Node(-1);
        Node temp = dummy;
        for(int no : nums){
            temp.next = new Node(no);
            temp = temp.next;
        }

        return dummy.next;
    }
    public static Node insertAtHead(Node head, int key){
        Node temp = new Node(key);
        if(head == null)
            return temp;
        temp.next = head;
        return temp;
    }
    public static Node insertAtTail(Node head, int key){
        Node temp = head;
        Node newNode = new Node(key);
        if(head == null)
            return newNode;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Node head = makeLLfromArr(list);
        Node.printLL(head);
        System.out.println("Length of the linked list is : " + Node.lengthOfLL(head));
        head = insertAtHead(head, 8);
        head = insertAtTail(head, 10);
        Node.printLL(head);
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the number you want to search in the linked list: ");
        boolean found = searchKey(sc.nextInt(), head);
        System.out.println("Key is present : " + found);

    }

    private static boolean searchKey(int key, Node head) {
        Node temp = head;
        while(temp != null){
            if(temp.data == key)
                return true;
            temp = temp.next;
        }

        return false;
    }
}
