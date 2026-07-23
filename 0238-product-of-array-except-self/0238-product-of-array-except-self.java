class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int length=nums.length;
        int[] answer = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];

        //left[i] stores the product of all elements to the left of index i
        left[0]=1;// Base case: no elements to the left of the first element
        for(int i=1;i<length;i++){
            left[i] = left[i-1]*nums[i-1]; //1*3 
        }
        // right[i] stores the product of all elements to the right of index i
        right[length-1]=1;// Base case: no elements to the right of the last element
        for(int i=length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        // Product of everything except self = (product of left elements) * (product of right elements)
        for(int i=0;i<length;i++){
            answer[i]=left[i]*right[i];
        }
    return answer;
    }
}