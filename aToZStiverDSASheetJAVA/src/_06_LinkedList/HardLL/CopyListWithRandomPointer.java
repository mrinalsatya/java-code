package aToZStiverDSASheetJAVA.src._06_LinkedList.HardLL;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        // O(N) - S, O(N)- T - using hashmap
        Map<Node, Node> list = new HashMap<>();
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            list.put(temp, newNode); // put in map (original as key, copy as value)
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node copyNode = list.get(temp);
            copyNode.next = list.get(temp.next);
            if(temp.random == null){
                copyNode.random = null;
            }else{
                copyNode.random = list.get(temp.random);
            }

            temp = temp.next;
        }
        return list.get(head);
    }
    // Optimal - O(3N) space - O(N) which answer demands;
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node temp = head;
        // 1. insert new node in between to nodes
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        //2. Make random pointers of new node point to orignal random next;
        while(temp != null){
            Node nextNode = temp.next;
            if(temp.random != null) nextNode.random = temp.random.next;
            temp = temp.next.next;
        }
        Node dummy = new Node(-1);
        Node res = dummy;
        // 3. insert new nodes in dummy and restore orignal list
        temp = head;
        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
