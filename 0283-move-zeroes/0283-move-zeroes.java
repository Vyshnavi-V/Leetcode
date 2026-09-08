class Solution {
    public void moveZeroes(int[] nums) {
        // TWO POINTER APPROACH
        int length=nums.length;
        int left=0;
        for(int right=0;right<length;right++){
            if(nums[right]!=0){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;

            }
        }
    }
}