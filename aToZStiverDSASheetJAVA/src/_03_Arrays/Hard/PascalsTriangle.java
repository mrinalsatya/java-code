package aToZStiverDSASheetJAVA.src._03_Arrays.Hard;
//https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = numRows;
            if(n == 1)
            {
                return new ArrayList<>(Arrays.asList(
                        new ArrayList<>(Arrays.asList(1))
                ));
            }
            ans.add(new ArrayList<>(Arrays.asList(1)));
            ans.add(new ArrayList<>(Arrays.asList(1,1)));
            for(int i = 3; i<=n; i++){
                List<Integer> temp = new ArrayList<>(Collections.nCopies(i, 0));
                temp.set(0, 1);
                temp.set(i-1, 1);
                for(int j = 1; j<i-1;j++){
                    int val = ans.get(i-2).get(j-1) + ans.get(i-2).get(j);
                    temp.set(j, val);
                }

                ans.add(temp);
            }
            return ans;
        }
    }
}
