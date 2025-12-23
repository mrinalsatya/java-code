package aToZStiverDSASheetJAVA.src._06_LinkedList.HardLL;

public class FlattenALinkedList {
    /**
     * Recursively merges two sorted linked lists using the `bottom` pointer.
     * This behaves exactly like merge step in merge-sort.
     * <p>
     * l1 and l2 are heads of two bottom-linked sorted lists.
     * <p>
     * Time Complexity of merge: O(M) where M = total bottom nodes across both lists
     */
    public static Node mergeTwoLL(Node l1, Node l2) {
        // If both lists are empty
        if (l1 == null && l2 == null)
            return null;

        // If one list becomes empty, return the other list
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        Node result;

        /**
         * Pick the smaller value among l1 and l2.
         * Recursively merge remaining lists.
         *
         * IMPORTANT: We merge using bottom pointers only,
         * because next pointers represent separate lists.
         */
        if (l1.data <= l2.data) {
            result = l1;
            result.bottom = mergeTwoLL(l1.bottom, l2);
        } else {
            result = l2;
            result.bottom = mergeTwoLL(l1, l2.bottom);
        }

        /**
         * VERY IMPORTANT:
         * After flattening, `next` pointer must NOT be used.
         * We must nullify it to ensure the list is a single chain
         * connected only through `bottom` pointers.
         */
        result.next = null;

        return result;
    }


    /**
     * Recursively flattens a linked list where:
     * - Each node has `next` pointer (points to next list)
     * - Each node has `bottom` pointer (sorted linked list)
     * <p>
     * Steps:
     * 1. Flatten the rest of the list (root.next)
     * 2. Merge current list with flattened next list
     * <p>
     * Time Complexity:
     * - Flatten: O(N)
     * - Each merge: O(M)
     * Overall worst-case: O(N * M)
     */
    public Node flatten(Node root) {
        // Base condition: If only one list or empty input
        if (root == null || root.next == null)
            return root;

        // Recursively flatten the next linked lists
        root.next = flatten(root.next);

        // Merge current list with already flattened next list
        root = mergeTwoLL(root, root.next);

        return root;
    }
}
