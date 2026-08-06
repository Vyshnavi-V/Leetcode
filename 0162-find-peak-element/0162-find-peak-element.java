class Solution {
    public int findPeakElement(int[] nums) {
        int length=nums.length;
        int max=0;
        int left=0;
        int right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid>left && mid<right){
                if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                    return mid;
                }
                else if(nums[mid-1]>nums[mid]){
                    right=mid-1;
                }
                else if(nums[mid+1]>nums[mid]){
                    left=mid+1;
                }
            }
            else{
                if(nums[left]>nums[right]){
                    return left;
                }
                else{
                    return right;
                }
            }

        }
    return 0;   
    }
}

