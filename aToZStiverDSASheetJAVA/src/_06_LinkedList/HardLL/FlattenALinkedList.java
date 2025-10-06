package aToZStiverDSASheetJAVA.src._06_LinkedList.HardLL;

public class FlattenALinkedList {
    //Time Complexity O(NM)
    public static Node mergeTwoLL(Node l1, Node l2){
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        Node result;

        if(l1.data <= l2.data){
            result = l1;
            result.bottom = mergeTwoLL(l1.bottom, l2);
        }else{
            result = l2;
            result.bottom = mergeTwoLL(l1, l2.bottom);
        }



        result.next = null;

        return result;
    }
    public Node flatten(Node root) {
        // code here
        if(root == null || root.next == null)
            return root;
        root.next = flatten(root.next);

        root = mergeTwoLL(root, root.next);

        return root;
    }
}
