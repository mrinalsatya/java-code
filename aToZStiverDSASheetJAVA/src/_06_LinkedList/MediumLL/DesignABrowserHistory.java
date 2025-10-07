package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumLL;

public class DesignABrowserHistory {
    class BrowserHistory {
        static class ListNode{
            String val;
            ListNode next;
            ListNode prev;
            public ListNode(String val){
                this.val = val;
            }
        }

        private ListNode curr;
        public BrowserHistory(String homepage) {
            curr = new ListNode(homepage);
        }

        public void visit(String url) {
            ListNode newNode = new ListNode(url);
            curr.next = null;
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        public String back(int k) {
            while(curr.prev != null && k-- > 0){
                curr = curr.prev;
            }
            return curr == null ? "" : curr.val;
        }

        public String forward(int k) {
            while(curr.next != null && k-- > 0){
                curr = curr.next;
            }

            return curr == null ? "" : curr.val;
        }
    }

}
