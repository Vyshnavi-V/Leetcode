class Solution {
    public int pivotIndex(int[] nums) {
        //Prefix Sum Approach
        //Total sum of the array
        int length=nums.length;
        int totalSum=0;
        for(int i=0;i<length;i++){
            totalSum+=nums[i];
        }
        //Find leftSum and rightSum
        int leftSum=0;
        for (int j=0;j<length;j++){
            // total sum - left sum - pivot index will give you the right sum.
            int rightSum = totalSum-leftSum-nums[j];  
            if(leftSum==rightSum){
                return j;
            }
            leftSum+=nums[j];
        }
        return -1;

    }
}