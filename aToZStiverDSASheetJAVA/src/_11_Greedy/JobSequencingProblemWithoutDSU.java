package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
/*
Key Interview Explanation - Uses a greedy strategy
 - Always schedules the most profitable job first
 - Assigns each job to the latest available time slot
 - This preserves earlier slots for other jobs
This ensures maximum total profit.

Time Complexity: Heap insertion → O(n log n) , Scheduling loop → O(n × maxDeadline) (worst case)
Space Complexity: Heap + schedule array → O(n)

(An optimized DSU-based version can reduce time further, but this is the standard interview solution.)
 */
public class JobSequencingProblemWithoutDSU {
    class Solution {

        /**
         * Pair class to represent a job
         * deadline -> last time slot by which job can be done
         * profit   -> profit earned by doing the job
         */
        class Pair {
            int deadline, profit;

            Pair(int deadline, int profit) {
                this.deadline = deadline;
                this.profit = profit;
            }
        }

        public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

            /**
             * Max-heap based on profit.
             * Jobs with higher profit are given priority.
             */
            PriorityQueue<Pair> pq =
                    new PriorityQueue<>((a, b) -> Integer.compare(b.profit, a.profit));

            int maxDeadline = -1;   // Maximum deadline among all jobs
            int totalProfit = 0;    // Total profit earned
            int jobsCount = 0;      // Number of jobs scheduled

            // Step 1: Push all jobs into the max-heap
            for (int i = 0; i < profit.length; i++) {
                pq.offer(new Pair(deadline[i], profit[i]));
                maxDeadline = Math.max(maxDeadline, deadline[i]);
            }

            /**
             * schedule[] array represents time slots:
             * schedule[i] = 1 means slot i is occupied
             * schedule[i] = 0 means slot i is free
             */
            int[] schedule = new int[maxDeadline + 1];

            // Step 2: Process jobs in descending order of profit
            while (!pq.isEmpty()) {

                Pair job = pq.poll();

                // Try to schedule this job in the latest available slot
                // before or on its deadline
                for (int j = job.deadline; j > 0; j--) {

                    // If the slot is free, assign the job
                    if (schedule[j] == 0) {
                        schedule[j] = 1;
                        jobsCount++;
                        totalProfit += job.profit;
                        break;
                    }
                }
            }

            // Step 3: Return result as [number of jobs done, total profit]
            return new ArrayList<>(Arrays.asList(jobsCount, totalProfit));
        }
    }

}
