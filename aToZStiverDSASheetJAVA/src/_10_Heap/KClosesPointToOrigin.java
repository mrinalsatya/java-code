package aToZStiverDSASheetJAVA.src._10_Heap;

//https://leetcode.com/problems/k-closest-points-to-origin/
//Time Complexity: O(n log k)
//
//Space Complexity: O(k)
public class KClosesPointToOrigin {
    class Solution {

        /**
         * Pair class:
         * first  -> squared distance from origin (x^2 + y^2)
         * second -> index of the point in the original array
         */
        class Pair {
            int first, second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        public int[][] kClosest(int[][] points, int k) {

            /**
             * Max-heap based on squared distance.
             * - Larger distance has higher priority (removed first).
             * - If distances are equal, larger index is removed first.
             *
             * Heap size is maintained at most k.
             */
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
                if (a.first != b.first) {
                    // Compare by squared distance (max-heap)
                    return Integer.compare(b.first, a.first);
                }
                // Tie-breaker (not strictly required here, but keeps ordering consistent)
                return Integer.compare(b.second, a.second);
            });

            // Iterate over all points
            int i = 0;
            for (int[] point : points) {

                // Calculate squared distance from origin
                // (No need to take square root for comparison)
                int sqSum = (point[0] * point[0]) + (point[1] * point[1]);

                // Add current point to the heap
                maxHeap.offer(new Pair(sqSum, i));

                // If heap size exceeds k, remove the farthest point
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }

                i++;
            }

            // Prepare result array
            int[][] ans = new int[k][2];
            int ind = 0;

            // Extract k closest points from heap
            while (!maxHeap.isEmpty()) {
                ans[ind++] = points[maxHeap.poll().second];
            }

            return ans;
        }
    }

}
