package aToZStiverDSASheetJAVA.src._14_Graph;
//https://leetcode.com/problems/course-schedule/
public class CourseSchedule_i {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // Adjacency list representation of graph
            List<List<Integer>> adj = new ArrayList<>();

            // indegree[i] = number of prerequisites for course i
            int[] indegree = new int[numCourses];

            // Initialize adjacency list
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }

            /*
             * Build graph
             * prerequisite [a, b] means:
             * b -> a (b must be taken before a)
             */
            for (int i = 0; i < prerequisites.length; i++) {
                int course = prerequisites[i][0];
                int prereq = prerequisites[i][1];

                adj.get(prereq).add(course);
                indegree[course]++;
            }

            // Queue for courses with no prerequisites
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            int completed = 0;

            // Kahn’s Algorithm (Topological Sort)
            while (!q.isEmpty()) {
                int node = q.poll();
                completed++;

                for (Integer next : adj.get(node)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            // If we were able to take all courses, return true
            return completed == numCourses;
        }
    }

}
