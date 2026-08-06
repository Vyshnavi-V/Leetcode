class Solution {
    public int findPeakElement(int[] nums) {
        int length=nums.length;
        int left=0;
        int right=length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            //If the right neighbor is larger: You are on an increasing slope, so a peak must exist somewhere to the right!!
            // Example: [1, 2, 3, 1] with left=0, right=3 -> mid pointing at index 1 (value 2).
            // nums[mid] (2) is less than nums[mid + 1] (3), so the array is going UP.
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }
            //If the right neighbor is smaller: You are on a decreaing slope (or at a peak), meaning a peak exists at your current position or to the left 
            // Example: [1, 2, 3, 1] with left=2, right=3 -> mid pointing at index 2 (value 3).
            // nums[mid] (3) is NOT less than nums[mid + 1] (1), so the array is going DOWN.
            else{
                right=mid;
            }
        }
    return left;
    }
}

