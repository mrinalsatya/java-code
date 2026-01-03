package aToZStiverDSASheetJAVA.src._10_Heap;
//https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
public class SortNearlySortedArray {
    class Solution {
        public void nearlySorted(int[] arr, int k) {
            // code here
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int i = 0;
            for(int num : arr){
                pq.offer(num);
                if(pq.size() > k){
                    arr[i++] = pq.peek();
                    pq.poll();
                }
            }

            while(!pq.isEmpty()){
                arr[i++] = pq.peek();
                pq.poll();
            }
        }
    }

}
