package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOnAnswers;
//https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
public class PaintersPartitionProblem {
    class Solution {
        public static boolean isPossible(int[] arr, int k, int time){
            int n = arr.length, count = 1, sum = 0;
            for(int i = 0; i<n; i++){
                if(arr[i] > time)
                    return false;
                if(sum + arr[i] <= time){
                    sum += arr[i];
                }else{
                    count++;
                    sum = arr[i];
                    if(count > k)
                        return false;
                }
            }

            return true;
        }
        public int minTime(int[] arr, int k) {
            // code here
            int n = arr.length, low = 1, high = 0;
            for(int num : arr){
                high+=num;
            }
            // int ans = -1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(isPossible(arr,k,mid)){
                    // ans = mid;
                    high = mid - 1;
                }else{
                    low = mid+1;
                }
            }

            return low;
        }
    }

}
