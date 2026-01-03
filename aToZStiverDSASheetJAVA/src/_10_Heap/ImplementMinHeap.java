package aToZStiverDSASheetJAVA.src._10_Heap;

public class ImplementMinHeap {
    class MinHeap {

        // Underlying dynamic array to store heap elements
        // Heap property: parent <= children
        List<Integer> heap = new ArrayList<>();

        // ===================== INSERT =====================
        // Adds a new element to the heap
        public void add(int val) {
            // Step 1: Add element at the end (maintains complete binary tree)
            heap.add(val);

            // Step 2: Fix heap property by moving element up
            heapifyUp(heap.size() - 1);
        }

        // ===================== PEEK =====================
        // Returns the minimum element (root of heap)
        public int peek() {
            // Root element always contains the minimum value
            return heap.get(0);
        }

        // ===================== REMOVE MIN =====================
        // Removes and returns the minimum element
        public int poll() {
            // Store the minimum value (root)
            int min = heap.get(0);

            // Remove the last element from the heap
            int last = heap.remove(heap.size() - 1);

            // If heap is not empty after removal
            if (!heap.isEmpty()) {
                // Move last element to root
                heap.set(0, last);

                // Restore heap property by moving element down
                heapifyDown(0);
            }

            // Return the removed minimum element
            return min;
        }

        // ===================== HEAPIFY UP =====================
        // Fixes heap property from bottom to top
        private void heapifyUp(int i) {
            // Continue until reaching root
            while (i > 0) {
                // Calculate parent index
                int parent = (i - 1) / 2;

                // If parent is already smaller, heap property is satisfied
                if (heap.get(parent) <= heap.get(i))
                    break;

                // Otherwise, swap with parent
                swap(i, parent);

                // Move up to parent index
                i = parent;
            }
        }

        // ===================== HEAPIFY DOWN =====================
        // Fixes heap property from top to bottom
        private void heapifyDown(int i) {
            int n = heap.size();

            while (true) {
                // Calculate left and right child indices
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                // Assume current index has the smallest value
                int smallest = i;

                // If left child exists and is smaller than current
                if (left < n && heap.get(left) < heap.get(smallest))
                    smallest = left;

                // If right child exists and is smaller than current
                if (right < n && heap.get(right) < heap.get(smallest))
                    smallest = right;

                // If current node is already the smallest, stop
                if (smallest == i)
                    break;

                // Otherwise, swap with the smallest child
                swap(i, smallest);

                // Move down to the swapped child index
                i = smallest;
            }
        }

        // ===================== SWAP =====================
        // Utility function to swap two elements in heap
        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

}
