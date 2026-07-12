class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int count=0;
       int length = nums.length;
       int window_count=0;
       int max_output=0;
        for(int i=0;i<length;i++){
            if(nums[i]==1){
                window_count++;
            }
            else{
                max_output=Math.max(max_output,window_count);
                window_count=0;
            }
        }
        return Math.max(max_output,window_count);
    }
}