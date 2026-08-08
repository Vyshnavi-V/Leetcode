class Solution {
    public int[] searchRange(int[] nums, int target) {
        //Binary Search Approach
        
       // Function to find the first (leftmost) occurrence
       int start=leftRange(nums,target);
       //Function to find the last (rightmost) occurrence
       int last=rightRange(nums,target);
       //Return the starting and ending indices 
       return new int[]{start,last};
    }
    
    // Left Position of the Element
    private int leftRange(int[] nums, int target){
        int length=nums.length;
        int left=0;
        int right=length-1;
        int start=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                start=mid; //Record current match as a potential first position
                right=mid-1; // Keep searching left to see if target appears earlier
            }
           else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return start;
    }

    //Right Position of the Element
    private int rightRange(int[] nums,int target){
        int length=nums.length;
        int left=0;
        int right=length-1;
        int last=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                last=mid; // Record current match as a potential last position
                left=mid+1; // Keep searching right to see if target appears later
            
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
    return last;
        
    }
}