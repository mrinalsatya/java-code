// if array does not contains duplicate

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while(low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than high, min must be in right half
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // Else min is in left half (including mid)
            else {
                high = mid;
            }
        }
        
        return nums[low]; // low == high
    }
}


//if array contains duplicate values

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum must be in right half
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                // Minimum is in left half (including mid)
                high = mid;
            } else {
                // nums[mid] == nums[high] → cannot decide, shrink high
                high--;
            }
        }

        return nums[low]; // low == high
    }
}
