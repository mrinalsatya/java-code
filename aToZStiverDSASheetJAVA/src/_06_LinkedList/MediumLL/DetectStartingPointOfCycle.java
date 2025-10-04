package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class DetectStartingPointOfCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        //Using extra space - brute
        // Map<ListNode, Integer> visited = new HashMap<>();
        // ListNode temp = head;
        // while(temp != null){
        //     if(visited.containsKey(temp))
        //         return temp;
        //     visited.put(temp, visited.getOrDefault(temp, 0) + 1);
        //     temp = temp.next;
        // }

        // return temp;

        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
