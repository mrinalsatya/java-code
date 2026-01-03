package aToZStiverDSASheetJAVA.src._10_Heap;
//https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=kth-smallest-element
public class KthSmallestElementInArray {
    class Solution {
        public int kthSmallest(int[] arr, int k) {
            // Code here
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int num : arr){
                pq.offer(num);
                if(pq.size() > k){
                    pq.poll();
                }
            }

            return pq.peek();
        }
}
