class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's Algorithm
        int length=nums.length;
        int sum=0;
        // Initialize max with the first element to correctly handle all-negative arrays (eg [-3,-2,-1])
        int max=nums[0];
        for(int i=0;i<length;i++){
            sum+=nums[i];
            max=Math.max(max,sum); 
            // If  sum drops below 0, reset it to 0 (Kadane's approach)
            if(sum<0){
                sum=0;
            }
          
        }

    return max;    

    }
}