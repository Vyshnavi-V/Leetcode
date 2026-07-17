class Solution {
    public void sortColors(int[] nums) {
        //DUTCH NATIONAL FLAG PROBLEM--------------------------------
        int length=nums.length;
        int start = 0;
        int middle =0;
        int end=length-1;
        // Process elements until the middle pointer crosses the end pointer
        while(middle<=end){
            // Swap the 2 at 'middle' with the element at 'end'
            if(nums[middle]==2){ 
                nums[middle]=nums[end];
                nums[end]=2;
                end--;
            }
            //if middle is 1, don't change anything, & increment the pointer
            else if(nums[middle]==1){
                middle++;
            }
            // Swap the 0 at 'middle' with the element at 'start'
            else{   // nums[middle]==0
                nums[middle]=nums[start];
                nums[start]=0;
                middle++;
                start++;
            }
        }
       
    }
    
}