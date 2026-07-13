class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // two pointer approach
        int length = numbers.length;
        int left=0;  // starting from 1st index
        int right=length-1; //starting from last index
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1,right+1};
            }
            // eg if sum is 17 and target is 9, decrement right pointer (array is sorted)
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