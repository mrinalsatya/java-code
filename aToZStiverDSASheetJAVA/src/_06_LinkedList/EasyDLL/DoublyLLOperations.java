package aToZStiverDSASheetJAVA.src._06_LinkedList.EasyDLL;

import aToZStiverDSASheetJAVA.src._06_LinkedList.DoublyNode;

import java.util.ArrayList;
import java.util.Arrays;

public class DoublyLLOperations {
    public static DoublyNode arrayListToDll(ArrayList<Integer> nums){
        DoublyNode dummy = new DoublyNode(-1);
        DoublyNode temp = dummy;
        for(int num : nums){
            DoublyNode newNode = new DoublyNode(num);
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        DoublyNode head = arrayListToDll(nums);
    }
}
