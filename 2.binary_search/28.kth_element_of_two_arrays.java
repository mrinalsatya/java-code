class Solution {
    public int kthElement(int nums1[], int nums2[], int k) {
        // code here
        int n1 = nums1.length, n2 = nums2.length, n = n1+n2;
        if(n1 > n2){
            return kthElement(nums2,nums1,k);
        }
        int low = Math.max(0, k- n2), high = Math.min(k,n1);
        int left = k;
        while(low <= high){
            int mid1 = low + (high-low)/2;
            int mid2 = left - mid1;
            int l1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }
            else if(l1 > r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }

        return 0;
    }
}