class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Two Pointer Approach
        int length=numbers.length;
        int left=0;
        int right=length-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
    return new int[]{-1,-1};
    }
}