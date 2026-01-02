package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;
//https://leetcode.com/problems/lru-cache/description/
public class LRUCache {
    class LRUCache {

        // Doubly Linked List Node
        class Node {
            int key, value;
            Node prev, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // Capacity of cache
        int capacity;

        // HashMap for O(1) access
        Map<Integer, Node> map = new HashMap<>();

        // Dummy head and tail nodes
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;

            // Initialize empty doubly linked list
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Get value of key if exists, else return -1
         */
        public int get(int key) {

            if (!map.containsKey(key))
                return -1;

            Node node = map.get(key);

            // Move accessed node to front (most recently used)
            remove(node);
            addFirst(node);

            return node.value;
        }

        /**
         * Put key-value pair into cache
         */
        public void put(int key, int value) {

            // If key already exists
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;

                remove(node);
                addFirst(node);
                return;
            }

            // If cache is full, remove LRU node
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            // Insert new node
            Node node = new Node(key, value);
            addFirst(node);
            map.put(key, node);
        }

        /**
         * Adds node right after head (most recently used)
         */
        private void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        /**
         * Removes node from its current position
         */
        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

}
