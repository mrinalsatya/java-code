// O(n + klogk) - n is the length of string and k is the unique character  count
class Solution {
    public String frequencySort(String s) {
       Map<Character, Integer> frequency = new HashMap<>();
       for(int i = 0; i< s.length(); i++){
        frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
       }

       List<Map.Entry<Character,Integer>> list = new ArrayList<>(frequency.entrySet());

       list.sort((a,b) -> b.getValue() - a.getValue());

       StringBuilder ans = new StringBuilder();

       for(Map.Entry<Character,Integer> e : list){
            char key = e.getKey();
            int count = e.getValue();
            while(count > 0){
                ans.append(key);
                count--;
            }
       }

       return ans.toString();
    }
}


// same complexity if we use max heap



class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: MaxHeap based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freq.entrySet());

        // Step 3: Build result
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}


// optimal using bucket sort