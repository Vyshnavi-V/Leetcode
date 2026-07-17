class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Sliding Window problem
        int length=nums.length;
        int windowCount=0;
        int prdct =1;
        int left=0;
        //edge case
        if(k<=1){
            return 0;
        }
        for(int right =0;right<length;right++){
            //Include the new element at the right pointer into our window
            prdct*=nums[right];
            //Shrink the window from the left if the product matches or exceeds k
            while(prdct >= k){
                prdct/=nums[left];
                left++; // Shrink the window by moving the left boundary forward
            }
            //Count all valid subarrays ending at the current 'right' position.
            windowCount+= right-left+1; 
        }
    return windowCount;
    }
}