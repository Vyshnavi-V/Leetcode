class Solution {
    public int maxProduct(int[] nums) {
        //Prefix+Suffix Approach
        int length=nums.length;
        int prefix=1;
        int suffix=1;
        int max=-10;
        for(int i=0;i<length;i++){
            //edge case (eg 0, 2, 3, 4, 0), if 0 is there hen reset it back to 1.
            if(prefix==0){
                prefix=1;
            }
            if(suffix==0){
                suffix=1;
            }
            // Multiply the current element from the front
            prefix*=nums[i];
            // Multiply the current element from the back
            // 'length - 1 - i' calculates the mirror index from the end of the array
            suffix*=nums[length-1-i];
            max=Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }
}