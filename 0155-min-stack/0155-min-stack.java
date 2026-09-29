class MinStack {
    // Stack Design Pattern
     // Main stack → stores all values
    private Deque<Integer> minStack = new ArrayDeque<>();
    // Min stack → stores the minimum value at each level
    private Deque<Integer> stack = new ArrayDeque<>();
    public MinStack() {
    // If you assign new ArrayDeque<>() when declaring the variables, the constructor body can be completely empty and it is valid
    }
    
    public void push(int value) {
       stack.push(value); // Push value into the main stack
       if(minStack.isEmpty()){  // If minStack is empty, current value becomes the minimum
        minStack.push(value);
       }
       else{ // Push the smaller between current value and previous minimum
        minStack.push(Math.min(value,minStack.peek()));
       }
    }
    
    public void pop() {
        stack.pop(); // Remove top value from main stack
        minStack.pop(); // Remove corresponding minimum
    }
    
    public int top() {
        int top = stack.peek();
        return top;
    }
    
    public int getMin() {
        return minStack.peek();  // Top of minStack is the current minimum
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/* Complexity:
Time Complexity:
 push(val): O(1)
 pop():     O(1)
 top():     O(1)
 getMin():  O(1)
 Space Complexity: O(N) — Stores at most 2 * N values across both stacks.
*/