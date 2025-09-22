//HashMap Based approach
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length, k=1, m = queries.length;
        int[] ans = new int[m];
        Map<Integer, Map<Integer, Integer>>  mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(nums[i] != x)
                continue;
            //Adds a key with a default value if absent, then returns the value for further operations.
            mp.computeIfAbsent(x, key -> new HashMap<>()).put(k, i);
            k++;
        }

        for(int i =0; i< m; i++){
            int y = queries[i];
            if(mp.containsKey(x) && mp.get(x).containsKey(y)){
                ans[i] = mp.get(x).get(y);
            }
            else{
                ans[i] = -1;
            }
        }

        return ans;
    }
}

//list based approad - cleaner, easy to understand

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> positions = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == x) positions.add(i); // 0-based index
        }

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int k = queries[i];
            ans[i] = (k <= positions.size()) ? positions.get(k - 1) : -1;
        }

        return ans;
    }
}
