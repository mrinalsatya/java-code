package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://leetcode.com/problems/binary-tree-right-side-view/description/
public class ViewRight {
    //Recursion | TC- O(n) | SC - O(h) , h - height of bt
    public class View_Right {
        List<Integer> ans = new ArrayList<>();

        public void solve(TreeNode root, int level){
            if(root == null){
                return;
            }
            if(ans.size() == level){
                ans.add(root.val);
            }
            solve(root.right, level+1);
            solve(root.left, level+1);
        }

        public List<Integer> rightSideView(TreeNode root) {
            solve(root, 0);
            return ans;
        }
    }
    //Iterative TC- O(n) | SC - O(n)
    class Solution {

        // Pair to store node with its level
        class Pair {
            TreeNode node;
            int level;

            Pair(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> ans = new ArrayList<>();

            // Edge case
            if (root == null) return ans;

            // BFS queue
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {

                Pair curr = q.poll();
                TreeNode node = curr.node;
                int level = curr.level;

                // If this is the first node encountered at this level,
                // it is the rightmost node (because right child is pushed first)
                if (level == ans.size()) {
                    ans.add(node.val);
                }

                // Push right child first
                if (node.right != null) {
                    q.offer(new Pair(node.right, level + 1));
                }

                // Push left child
                if (node.left != null) {
                    q.offer(new Pair(node.left, level + 1));
                }
            }

            return ans;
        }
    }

}
