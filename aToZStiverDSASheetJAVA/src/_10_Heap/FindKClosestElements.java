package aToZStiverDSASheetJAVA.src._10_Heap;
//https://leetcode.com/problems/find-k-closest-elements/
//Time Complexity: O(n log k)
//Space Complexity: O(k)
public class FindKClosestElements {
    class Solution {

        /**
         * Pair class:
         * first  -> absolute distance from x
         * second -> actual array value
         */
        class Pair {
            int first, second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            // Result list
            List<Integer> ans = new ArrayList<>();

            /**
             * Max-heap based on:
             * 1) Larger distance first
             * 2) If distance is same, larger value first
             *
             * This ensures the "worst" candidate is removed first
             * when heap size exceeds k.
             */
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.first != b.first) {
                    // Compare by distance (max-heap)
                    return Integer.compare(b.first, a.first);
                }
                // Tie-breaker: compare by value (max-heap)
                return Integer.compare(b.second, a.second);
            });

            // Process each number in the array
            for (int num : arr) {

                // Push pair: (distance from x, value)
                pq.offer(new Pair(Math.abs(x - num), num));

                // Keep heap size limited to k
                // Remove the farthest element if size exceeds k
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            // Extract elements from heap
            // These are the k closest elements (unordered)
            while (!pq.isEmpty()) {
                ans.add(pq.peek().second);
                pq.poll();
            }

            // Sort the result as required by the problem
            Collections.sort(ans);

            return ans;
        }
    }

}
