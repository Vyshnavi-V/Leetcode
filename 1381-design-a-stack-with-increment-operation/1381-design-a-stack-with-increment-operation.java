class CustomStack {
    // Approach: Direct Array Implementation with Pointer instead of using stack data structure
    private int[] arr;
    private int max;
    private int index=-1;
    public CustomStack(int maxSize) {
        max=maxSize;
        arr = new int[max];
        this.index=index; // Points to the current top element (-1 means empty)
    }
    
    public void push(int x) { // Time Complexity: O(1)
        // Pushes x to the array(stack) if capacity has not been reached
        if(index+1 < max){
            index++;
            arr[index]=x;
        }
    }
    
    public int pop() { // Time Complexity: O(1)
        //  returns the top of the array (stack), or -1 if empty.
        if(index!=-1){
            int pop=arr[index];
            index--;
        return pop;
        }
    return -1;
    }
    
    public void increment(int k, int val) { // Time Complexity: O(min(k, size))
        // Increments the bottom k elements of the stack by val.
        int limit = Math.min(k,index+1);
        for(int i=0;i<limit;i++){
            arr[i]=arr[i]+val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */