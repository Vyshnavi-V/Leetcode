class Solution {
    public int searchInsert(int[] nums, int target) {
        //Binary Search Approach
        int length=nums.length;
        int left=0;
        int right=length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left= mid+1;
            }
            else{
                right=mid-1;
            }
        }
    // When target is not found, the loop exits with left > right. 
    //Left points to the insert position of the target element!!
    return left;
    }
}