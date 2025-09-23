class Solution { 
    public int findKRotation(ArrayList<Integer> nums) { 
        int n = nums.size(), low = 0, high = n-1; 
        while(low<high)
        { 
            int mid = low + (high-low)/2; 
            
            if(nums.get(mid) > nums.get(high)) 
                low = mid + 1; 
            else 
                high = mid; 
        } 
        return low; 
    } 
}