class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //Sliding Window Pattern
        int length=nums.length;
        int left=0;
        int minCount=Integer.MAX_VALUE;
        int sum=0,count=0;
        for(int right=0;right<length;right++){
            //Expand Window
            sum+=nums[right];
//While the condition satisfies, we need to shrink the window from left to find the next min length
            while(sum>=target){
                minCount=Math.min(minCount,right-left+1);
                    sum-=nums[left];
                    left++;
            }
        }
        // If minCount is still infinity, it means no valid subarray ever hit the target. Return 0.
        // Otherwise, return our recorded minimum length.
        return minCount==Integer.MAX_VALUE?0:minCount;
    }
}