class Solution {
    public int search(int[] nums, int target) {
        //Modified Binary Searcg
        int length=nums.length;
        int left=0;
        int right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //Left Sorted Array(LEFT HALF IS SORTED)
            // Eg [4, 5, 6, 7, 0, 1, 2] with mid pointing at 7.
            //mid(7) is greater than 4 (nums[left]) so it is left sorted array
            if(nums[mid]>=nums[left]){
                //We will check weather the target is in between the range of left and mid
                if(target>=nums[left] && target<nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            //Right Sorted Array(RIGHT HALF IS SORTED)
            // Eg [5,1,2,3,4] with mid pointing at 2.
            //mid(2) is not greater than 5 (nums[left]) so it is a right sorted array
            else{
                 //We will check weather the target is in between the range of mid and right
                if(target>nums[mid] && target<=nums[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
    return -1;
    }
}