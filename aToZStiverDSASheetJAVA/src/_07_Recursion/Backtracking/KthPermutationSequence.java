package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;

public class KthPermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        // Step 1: Prepare factorial and list [1, 2, ..., n]
        int fact = 1;
        for(int i=1; i<n; i++){
            nums.add(i);
            fact = fact * i;
        }
        nums.add(n);

        StringBuilder ans = new StringBuilder();
        // Step 2: Convert k to 0-based
        k -= 1;
        // Step 3: Find each digit
        while(true){
            int index = k / fact;
            ans.append(nums.get(index));
            nums.remove(index);
            if(nums.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / nums.size(); // siez of the new list
        }

        return ans.toString();
    }
}
