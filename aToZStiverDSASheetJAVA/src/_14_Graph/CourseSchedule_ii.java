package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/course-schedule-ii/
public class CourseSchedule_ii {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            // Adjacency list to represent graph
            List<List<Integer>> adj = new ArrayList<>();

            // indegree[i] = number of prerequisites for course i
            int[] indegree = new int[numCourses];

            // Result array for topological order
            int[] ans = new int[numCourses];
            int k = 0;

            // Initialize adjacency list
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }

            /*
             * Build the graph
             * prerequisite [a, b] means:
             * b -> a (b must be taken before a)
             */
            for (int i = 0; i < prerequisites.length; i++) {
                int course = prerequisites[i][0];
                int prereq = prerequisites[i][1];
                adj.get(prereq).add(course);
                indegree[course]++;
            }

            // Queue to store courses with no prerequisites
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            // Kahn's Algorithm (BFS)
            while (!q.isEmpty()) {
                int node = q.poll();
                ans[k++] = node;

                // Reduce indegree of dependent courses
                for (Integer nei : adj.get(node)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }

            // If not all courses are processed, cycle exists
            if (k != numCourses) {
                return new int[0];
            }

            return ans;
        }
    }

}
