package aToZStiverDSASheetJAVA.src._06_LinkedList.MediumDLL;

public class PairsWithGivenSumK {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // Brute find all pairs with 2 loop = O(n2)
        //Better - use hashmap O(n) + O(nlogn) ans space O(n);
//
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        Node temp = head;
//        while(temp != null){
//            int sum = target -  temp.data;
//            if(map.containsKey(sum)){
//                int x = sum;
//                int y = temp.data;
//                ArrayList<Integer> arr = new ArrayList<>();
//                arr.add(x);
//                arr.add(y);
//                ans.add(arr);
//            }
//            map.put(temp.data, map.getOrDefault(map.get(temp.data), 0) + 1);
//            temp = temp.next;
//        }
//        if (!ans.isEmpty()) {
//            Collections.sort(ans, (a, b) -> Integer.compare(a.get(0), b.get(0)));
//        }
//        return  ans;

        //Optimal - using 2 pointers approach;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(head == null || head.next == null)
            return ans;
        Node left = head;
        Node right = head;
        while(right.next != null) right = right.next;
        while(left != right && left.prev != right){
            int sum = left.data + right.data;
            if(sum == target){
                ans.add(new ArrayList(Arrays.asList(left.data,right.data)));
                left = left.next;
                right = right.prev;
            }
            else if(sum > target){
                right = right.prev;
            }
            else{
                left = left.next;
            }
        }
        return  ans;
    }
}
