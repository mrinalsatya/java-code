package aToZStiverDSASheetJAVA.src._10_Heap;
//https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
/*
Uses a greedy strategy

Always merges the two smallest ropes first

Larger ropes are delayed to avoid being added multiple times

This is the Optimal Merge Pattern (same idea as Huffman Coding)

Time Complexity: O(n log n) | Space Complexity: O(n)
“We use a min-heap and greedily merge the two smallest ropes each time, which guarantees the minimum total cost.”
 */
public class MinimumCostToConnectNRopes {
    class Solution {
        public static int minCost(int[] arr) {

            // Min-heap to always extract the two smallest ropes
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // Total minimum cost of connecting all ropes
            int cost = 0;

            // Step 1: Insert all rope lengths into the min-heap
            for (int num : arr) {
                minHeap.offer(num);
            }

            // Step 2: Keep merging until only one rope remains
            while (minHeap.size() > 1) {

                // Extract the two smallest ropes
                int first = minHeap.poll();
                int second = minHeap.poll();

                // Cost to connect these two ropes
                int merged = first + second;

                // Add this cost to total cost
                cost += merged;

                // Insert the merged rope back into the heap
                minHeap.offer(merged);
            }

            // Final minimum cost after all ropes are connected
            return cost;
        }
    }

}
