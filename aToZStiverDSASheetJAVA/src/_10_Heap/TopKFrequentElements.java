package aToZStiverDSASheetJAVA.src._10_Heap;
//https://leetcode.com/problems/top-k-frequent-elements/description/
//Time Complexity - Frequency counting → O(n) , Heap operations → O(n log k) -  TC - O(n log k)
//Space Complexity - HashMap → O(n) , Heap → O(k) - SC - O(n)
public class TopKFrequentElements {
    class Solution {

        /**
         * Pair class:
         * first  -> frequency of the number
         * second -> the number itself
         */
        class Pair {
            int first, second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {

            // Result array to store top k frequent elements
            int[] ans = new int[k];
            int ind = 0;

            // Step 1: Build frequency map
            // Key   -> number
            // Value -> frequency of the number
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            /**
             * Step 2: Min-heap based on frequency
             * - Smaller frequency has higher priority (comes out first)
             * - Heap size is maintained at most k
             */
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.first, b.first)
            );

            // Step 3: Push frequency pairs into heap
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

                // Add (frequency, number) pair
                pq.offer(new Pair(entry.getValue(), entry.getKey()));

                // If heap size exceeds k, remove the least frequent element
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            // Step 4: Extract elements from heap
            // These are the k most frequent elements
            while (!pq.isEmpty()) {
                ans[ind++] = pq.poll().second;
            }

            return ans;
        }
    }

}
