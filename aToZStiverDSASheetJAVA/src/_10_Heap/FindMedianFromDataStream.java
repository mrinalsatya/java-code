package aToZStiverDSASheetJAVA.src._10_Heap;
//https://leetcode.com/problems/find-median-from-data-stream/description/
/*
Key Interview Explanation
 - Two heaps approach
 - Max-heap → left half (smaller numbers)
 - Min-heap → right half (larger numbers)
Heaps are balanced so that:
 - left.size() == right.size() or
 - left.size() == right.size() + 1
Median is always at the top(s) of the heaps
Complexity (Optimal) | addNum() → O(log n) | findMedian() → O(1) | Space → O(n)
 */
public class FindMedianFromDataStream {
    class MedianFinder {

        // Max-heap to store the smaller half of the numbers
        // Top element represents the largest value in the left half
        PriorityQueue<Integer> leftMaxHeap;

        // Min-heap to store the larger half of the numbers
        // Top element represents the smallest value in the right half
        PriorityQueue<Integer> rightMinHeap;

        public MedianFinder() {
            // Max-heap for left half
            leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

            // Min-heap for right half
            rightMinHeap = new PriorityQueue<>();
        }

        /**
         * Adds a number into the data structure.
         */
        public void addNum(int num) {

            // Step 1: Insert the number into the left (max) heap
            leftMaxHeap.offer(num);

            // Step 2: Move the largest element of left heap
            // to the right heap to maintain ordering
            rightMinHeap.offer(leftMaxHeap.poll());

            // Step 3: Balance the sizes
            // Ensure left heap has equal or one extra element
            if (rightMinHeap.size() > leftMaxHeap.size()) {
                leftMaxHeap.offer(rightMinHeap.poll());
            }
        }

        /**
         * Returns the median of all elements so far.
         */
        public double findMedian() {

            // If total number of elements is odd,
            // median is the top of the max-heap
            if (leftMaxHeap.size() > rightMinHeap.size()) {
                return leftMaxHeap.peek();
            }

            // If total number of elements is even,
            // median is the average of the two middle values
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
    }

}
