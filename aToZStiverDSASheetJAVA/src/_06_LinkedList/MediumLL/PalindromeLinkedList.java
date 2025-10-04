package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public static ListNode findMiddle(ListNode head){
            ListNode slow = head;
            ListNode fast = head;
            while(fast!=null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        public static ListNode reverseMid(ListNode head){
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;

            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null)
                return true;
            ListNode mid = findMiddle(head);
            mid = reverseMid(mid);
            ListNode temp = head;
            while(temp!= null && mid != null){
                if(temp.val != mid.val){
                    reverseMid(mid);
                    return false;
                }
                temp = temp.next;
                mid = mid.next;
            }
            reverseMid(mid);
            return true;
        }
    }
}
