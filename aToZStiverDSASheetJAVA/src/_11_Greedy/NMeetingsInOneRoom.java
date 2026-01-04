package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
//Time Complexity: O(n log n)
//
//Space Complexity: O(n)
public class NMeetingsInOneRoom {
    class Solution {

        /**
         * Pair class to represent a meeting
         * start -> start time of the meeting
         * end   -> end time of the meeting
         * pos   -> original position (not required here, but useful in some variants)
         */
        class Pair {
            int start, end, pos;

            Pair(int start, int end, int pos) {
                this.start = start;
                this.end = end;
                this.pos = pos;
            }
        }

        // Function to find the maximum number of meetings
        // that can be performed in one meeting room
        public int maxMeetings(int start[], int end[]) {

            int n = start.length;

            /**
             * Min-heap (PriorityQueue) ordered by meeting end time.
             * Meetings that finish earlier are processed first.
             */
            PriorityQueue<Pair> pq =
                    new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

            // Step 1: Insert all meetings into the priority queue
            for (int i = 0; i < n; i++) {
                pq.offer(new Pair(start[i], end[i], i + 1));
            }

            // Step 2: Select the meeting that ends earliest
            int count = 1;
            int endTime = pq.peek().end;
            pq.poll();

            // Step 3: Process remaining meetings
            while (!pq.isEmpty()) {

                Pair curr = pq.poll();

                // If the current meeting starts strictly after
                // the previously selected meeting ends,
                // we can attend this meeting
                if (curr.start > endTime) {
                    count++;
                    endTime = curr.end;
                }
            }

            // Return maximum number of non-overlapping meetings
            return count;
        }
    }

}
