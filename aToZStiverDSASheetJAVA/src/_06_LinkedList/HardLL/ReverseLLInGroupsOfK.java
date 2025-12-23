package aToZStiverDSASheetJAVA.src._06_LinkedList.HardLL;
//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseLLInGroupsOfK {
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

        /**
         * Reverses an entire linked list and returns the new head.
         * Standard iterative reversal using three pointers.
         */
        public ListNode reverseLL(ListNode head){
            // If list is empty or has only one node, no need to reverse
            if(head == null || head.next == null){
                return head;
            }

            ListNode prev = null;      // Will become new head after reversal
            ListNode curr = head;      // Current node being processed
            ListNode next = null;      // Temporarily stores next node

            // Reverse links one by one
            while(curr != null){
                next = curr.next;   // Save next node
                curr.next = prev;   // Reverse current node's pointer
                prev = curr;        // Move prev forward
                curr = next;        // Move curr forward
            }

            // prev is the new head of reversed list
            return prev;
        }

        /**
         * Returns the k-th node starting from 'temp'.
         * If fewer than k nodes exist, returns null.
         */
        public ListNode findKthNode(ListNode temp, int k){
            ListNode kthNode = temp;

            // Move k-1 steps ahead
            for(int i = 1; i < k; i++){
                if(kthNode == null){
                    return null; // Not enough nodes
                }
                kthNode = kthNode.next;
            }

            return kthNode;
        }

        /**
         * Reverses nodes of the linked list in groups of size k.
         * Remaining nodes (< k) at the end are left as-is.
         */
        public ListNode reverseKGroup(ListNode head, int k) {

            // Edge cases: no reversal needed
            if(head == null || head.next == null || k == 1){
                return head;
            }

            ListNode temp = head;        // Pointer to traverse list group by group
            ListNode prevNode = null;   // Tail of the previously reversed group
            ListNode kthNode = null;    // k-th node of current group
            ListNode nextNode = null;   // Node after the current k-group

            while(temp != null){

                // Find the k-th node of the current group
                kthNode = findKthNode(temp, k);

                // If less than k nodes remain
                if(kthNode == null){
                    // Connect the remaining nodes as-is
                    if(prevNode != null){
                        prevNode.next = temp;
                    }
                    break;
                }

                // Save the node after the current group
                nextNode = kthNode.next;

                // Detach the current k-group
                kthNode.next = null;

                // Reverse the current group
                reverseLL(temp);

                // If this is the first group, update head
                if(temp == head){
                    head = kthNode;
                } else {
                    // Connect previous group to current reversed group
                    prevNode.next = kthNode;
                }

                // temp becomes the tail after reversal
                prevNode = temp;

                // Move temp to the next group
                temp = nextNode;
            }

            return head;
        }
    }

}
