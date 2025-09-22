//Recursive Approach
//Time Complexity - O(n) worst case

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = -1, lastOcc = -1, n = nums.length;
        int low = 0, high = n-1;
        int[] ans = new int[2];
        ans[0] = firstOcc;
        ans[1] = lastOcc;
        binarySearch(nums, target, low, high, ans);
        return ans;
    }

    public void binarySearch(int[] nums, int target, int low, int high, int[] ans){
        if(low>high)
            {
                return;
            }

            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                if(ans[0] == -1 || mid < ans[0]){
                    ans[0] = mid;
                }
                if(ans[1] == -1 || mid > ans[1])
                {
                    ans[1] = mid;
                }
                binarySearch(nums, target, low, mid-1, ans);
                binarySearch(nums, target, mid+1, high, ans);
            }else if(nums[mid] > target){
                binarySearch(nums, target, low, mid-1, ans);
            }else{
                binarySearch(nums, target, mid+1, high, ans);
            }
    }
}


//Iterative Approach
//Time Complexity - O(log(n)) + O(log(n))

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { findFirst(nums, target), findLast(nums, target) };
    }

    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1; // keep going left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1; // keep going right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
