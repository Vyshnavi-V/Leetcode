class Solution {
    public int findMin(int[] nums) {
        //Modified Binary Search
        int length=nums.length;
        int left=0;
        int right=length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            //  The right portion is sorted.
            // Example: [5,0,1,2,3,4] where mid is 1 and right is 4.
            // Since 1 <= 4, ao the minimum is either at mid itself or somewhere to its left.
            if(nums[mid]<=nums[right]){
                right=mid;
            }
            // Right half is not sorted
            // Example: [4, 5, 6, 7, 0, 1, 2] where mid is 7 and right is 2.
            // Since 7 > 2, the inflection point (minimum) MUST lie strictly to the right of mid.
            else{
                left=mid+1;
            }
        }
    return nums[left];
    }
}