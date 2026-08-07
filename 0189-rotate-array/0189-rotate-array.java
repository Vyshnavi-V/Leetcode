class Solution {
    public void rotate(int[] nums, int k) {
        // Two Pointer Approach
        int length=nums.length;
        // Ensure k is within bounds (e.g., k=3 on length=2 becomes k=1)
        k=k%length;
        // Reverse the entire array, eg [1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
        reverse(nums,0,length-1);
        // Reverse the first k element , eg: [7,6,5] -> [5,6,7], so array becomes [5,6,7,4,3,2,1]
        reverse(nums,0,k-1);
        // Reverse the remaining  elements from k to length ,[4,3,2,1] -> [1,2,3,4], so array becomes [5,6,7,1,2,3,4]
        reverse(nums,k,length-1);
    }
    private void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }

}