package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class NodesAtDistanceK {
    class Solution {

        public Map<TreeNode, TreeNode> getParents(TreeNode root) {
            Map<TreeNode, TreeNode> parents = new HashMap<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    parents.put(curr.left, curr);
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    parents.put(curr.right, curr);
                    q.offer(curr.right);
                }
            }
            return parents;
        }

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;

            // Parent mapping
            Map<TreeNode, TreeNode> parents = getParents(root);

            // Visited map
            Map<TreeNode, Boolean> visited = new HashMap<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(target);
            visited.put(target, true);

            int dist = 0;

            while (!q.isEmpty()) {

                int size = q.size();

                // Stop when we reach distance k
                if (dist == k) break;

                for (int i = 0; i < size; i++) {

                    TreeNode curr = q.poll();

                    // Left child
                    if (curr.left != null && !visited.containsKey(curr.left)) {
                        visited.put(curr.left, true);
                        q.offer(curr.left);
                    }

                    // Right child
                    if (curr.right != null && !visited.containsKey(curr.right)) {
                        visited.put(curr.right, true);
                        q.offer(curr.right);
                    }

                    // Parent
                    TreeNode parent = parents.get(curr);
                    if (parent != null && !visited.containsKey(parent)) {
                        visited.put(parent, true);
                        q.offer(parent);
                    }
                }

                dist++;
            }

            // Remaining nodes are at distance k
            while (!q.isEmpty()) {
                ans.add(q.poll().val);
            }

            return ans;
        }
    }

}
