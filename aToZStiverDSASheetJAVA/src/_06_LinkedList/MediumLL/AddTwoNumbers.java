package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null || l2 != null || carry > 0){
            int sum = 0;
            if(l1 != null){
                sum+= l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;

            carry = sum/10;
            ListNode temp = new ListNode(sum%10);
            curr.next = temp;
            curr = temp;
        }
        return dummy.next;
    }
}
