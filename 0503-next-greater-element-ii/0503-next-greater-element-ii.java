class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Monotonic Stack Pattern
        //Time Complexity:  O(N) - each element is pushed and popped at most twice
        // Space Complexity: O(N) - stack holds at most N elements
        int length=nums.length;
        Deque<Integer> myStack =  new ArrayDeque<>();
        int[] arr = new int[nums.length];
        Arrays.fill(arr,-1);
        //Loop runs 2 * length times to simulate circularity (example(1,2,1): will bcome 1,2,1,1,2,1)
        for(int i=2*length-1;i>=0;i--){
            int current=nums[i%length];
            while(!myStack.isEmpty() && myStack.peek()<=current){
                myStack.pop(); // pop all elements smaller than or equal to current.
            }
            if(i<length && !myStack.isEmpty()){
                //top of the stack is the next larger element to the right
                arr[i]=myStack.peek();
            }
            // push 'current' to the stack 
            myStack.push(current);
           
        }
    return arr;
    }
}
/* Using modulo Operator in current=nums[i%length]; Line 12
As the pointer goes beyond the original array length (2*length ), using nums[i % n] maps these virtual indices back to valid, original positions within the to range.
 */