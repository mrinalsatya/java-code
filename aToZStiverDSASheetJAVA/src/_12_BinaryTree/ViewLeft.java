package aToZStiverDSASheetJAVA.src._12_BinaryTree;
//https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class ViewLeft {
    class Solution {
        ArrayList<Integer> ans = new ArrayList<>();
        public void helper(Node root, int level){
            if(root == null) return;
            if(level == ans.size()){
                ans.add(root.data);
            }
            helper(root.left, level+1);
            helper(root.right, level+1);
        }
        public ArrayList<Integer> leftView(Node root) {
            // code here
            helper(root, 0);
            return ans;
        }
    }
}
