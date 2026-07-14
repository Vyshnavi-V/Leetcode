class Solution {
    public int longestOnes(int[] nums, int k) {
       int length=nums.length;
       int start=0;
       int zeroCount=0;
       int maxLength=0;
       int currentLength=0;
       for(int end=0;end<length;end++){
        // If the current element is 0, include it in the window by increasing zeroCount
            if(nums[end]==0){
                zeroCount++;
            }
// If the number of zeros becomes greater than k, shrink the window from the left until it becomes valid again.
            while(zeroCount > k){
                if(nums[start]==0){
                    zeroCount--;
                }
                start++;
            }
        currentLength = end - start + 1;
        maxLength = Math.max(maxLength,currentLength);
       }
    return maxLength;
    }
}