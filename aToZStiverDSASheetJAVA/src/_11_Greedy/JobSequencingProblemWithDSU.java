package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
/*
Key Optimization Idea (Interview Explanation)
 - Each time slot points to the next free slot on the left
 - Once a slot is used, we union it with the previous slot
 - This lets us jump directly to the next available slot

Optimal DSU-Based Solution (NO TLE) | TC: O(n log n) | SC: O(n)
 */
public class JobSequencingProblemWithDSU {
    class Solution {

        class Pair {
            int deadline, profit;
            Pair(int d, int p) {
                deadline = d;
                profit = p;
            }
        }

        // DSU parent array
        int[] parent;

        // Find with path compression
        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        // Union current slot with previous slot
        void union(int u, int v) {
            parent[u] = v;
        }

        public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

            int n = profit.length;

            // Max-heap by profit
            PriorityQueue<Pair> pq =
                    new PriorityQueue<>((a, b) -> b.profit - a.profit);

            int maxDeadline = 0;
            for (int i = 0; i < n; i++) {
                pq.offer(new Pair(deadline[i], profit[i]));
                maxDeadline = Math.max(maxDeadline, deadline[i]);
            }

            // Initialize DSU
            parent = new int[maxDeadline + 1];
            for (int i = 0; i <= maxDeadline; i++) {
                parent[i] = i;
            }

            int jobsCount = 0;
            int totalProfit = 0;

            // Process jobs by highest profit
            while (!pq.isEmpty()) {
                Pair job = pq.poll();

                // Find latest available slot
                int availableSlot = find(job.deadline);

                if (availableSlot > 0) {
                    // Schedule job
                    jobsCount++;
                    totalProfit += job.profit;

                    // Mark slot as occupied
                    union(availableSlot, availableSlot - 1);
                }
            }

            return new ArrayList<>(Arrays.asList(jobsCount, totalProfit));
        }
    }

}
