package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOnAnswers;
//https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
public class FindTheNthRoot {
    class Solution {
        public int findPow(int k, int n, int m){
            int ans = 1;
            for(int i = 0; i<n; i++){
                ans*=k;
                if(ans > m){
                    return 2;
                }
            }

            return ans==m? 1 : 0;
        }
        public int nthRoot(int n, int m) {
            // code here
            if(m==0) return 0;
            int low = 1, high = m;
            while(low <= high){
                int mid = low + (high-low)/2;
                int pow = findPow(mid, n, m);
                if(pow == 1){
                    return mid;
                }else if (pow == 2){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            return -1;
        }
    }
}
