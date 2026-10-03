class CustomStack {
    // Stack Design BruteForce Approach
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    public CustomStack(int maxSize) {
        max=maxSize;
    }
    
    public void push(int x) {
        // Adds x to the top of the stack if the stack has not reached maxSize.
        if(stack.size()<max){
            stack.push(x);
        }
    }
    
    public int pop() {
        // Deletes and returns the top of the stack, or -1 if the stack is empty.
        if(!stack.isEmpty()){
            return stack.pop();
        }
    return -1;
    }
    List<Integer> list = new ArrayList<>();
    public void increment(int k, int val) {
        // Clear old items from previous increment calls
        list.clear();
        // Traversing java.util.Stack naturally reads from BOTTOM to TOP
        for(int i:stack){
            list.add(i);
        }
        int count=0;
        // Increment
        while(count<k && count<list.size()){
            list.set(count,list.get(count)+val);
        count++;
        }
        // Empty the original stack completely
        while(!stack.isEmpty()){
            stack.pop();
        }
        // Push the updated values back into the stack from bottom to top
        for(int i:list){
            stack.push(i);
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

 /*
 * Complexity:
     Time Complexity:
        push(x): O(1)
        pop():   O(1)
        increment(k, val): O(N) where N is the current number of elements in the stack.
        Space Complexity: O(N) auxiliary space used by the temporary list buffer.
  */ 