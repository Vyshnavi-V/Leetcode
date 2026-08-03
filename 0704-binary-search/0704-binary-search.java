class Solution {
    public int search(int[] nums, int target) {
       //Non recursion method
        int length=nums.length;
        int left=0;int right=length-1;
        while(left<=right){
            // Calculate midpoint safely to prevent integer overflow: left + (right - left) / 2
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
    return -1;
    }
}



 /* Recursion method
        int length=nums.length;
        int left=0;
        int right=length-1;
        return myFun(nums,left,right,target);
    }
    int myFun(int[] nums,int left,int right,int target){
            if(left>right){
                return -1;
            }
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                return myFun(nums,mid+1,right,target);
            }
            else{
                return myFun(nums,left,mid-1,target);
            }
    }
*/