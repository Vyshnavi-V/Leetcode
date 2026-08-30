class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Pattern: Monotonic Stack (Right-to-Left) + HashMap
        // Stack Implementation using DEQUE
        // Map stores: key = number in nums2, value = its next greater element
        HashMap<Integer,Integer> map = new HashMap<>(); 
        Deque<Integer> myStack = new ArrayDeque<>();
        int[] arr = new int[nums1.length];
        int nextGreater=-1;
        // Process nums2 from Right to Left, Moving right-to-left ensures that any elements currently in the stack are greater to the right of the current index.
        for(int i=nums2.length-1;i>=0;i--){
            int current=nums2[i];
            while(!myStack.isEmpty() && myStack.peek()<=current){
                myStack.pop(); // pop all elements smaller than or equal to current.
            }
            if(myStack.isEmpty()){ // - If the stack is empty, no element to the right is larger -> -1
                nextGreater = -1;
            }
            else{ // - Otherwise, the top of the stack is the next larger element to the right
                nextGreater = myStack.peek();
            }
            // Store the current element and it's next greater element in the map 
            map.put(current,nextGreater);
            // push 'current' to the stack 
            myStack.push(nums2[i]);
        }
        // Look up for each value from the map
        for(int i=0;i<nums1.length;i++){
            arr[i]=map.get(nums1[i]);
        }
    return arr;
    }
}


/* Brute Force Approach
        int[] arr = new int[nums1.length];
        Arrays.fill(arr,-1);
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    for(int k=j+1;k<nums2.length;k++){
                        if(nums2[k]>nums2[j]){
                            arr[i]=nums2[k];
                            break;
                        }
                    }
                }
            }
        }
    return arr;
*/