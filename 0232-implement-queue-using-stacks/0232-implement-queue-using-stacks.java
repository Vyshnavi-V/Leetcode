class MyQueue {
    Stack<Integer> stack1 = new Stack<>(); // stack1 → used to add new elements
    Stack<Integer> stack2 = new Stack<>();  // stack2 → used to remove/peek elements in queue  order
    public MyQueue() {
        // If you assign new Stack<>() when declaring the variables, the constructor body can be completely empty and it is valid
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        // If stack2 is empty, move all elements from stack1 to stack2
       if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
       }
       return stack2.pop(); // Remove and return the front element
    }
    
    public int peek() {
        // If stack2 is empty, move all elements from stack1 to stack2
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
       }
       return stack2.peek(); // Return the front element
    } 
    
    public boolean empty() {
        // Queue is empty only when both stacks are empty
        return stack2.isEmpty() && stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

 /*
    We use `stack1`  to receive all incoming elements.
    We use `stack2`  to serve elements in FIFO order.
    Complexity:
    Time: push() is O(1). pop() and peek() are Amortized O(1). empty() is O(1).
    Space: O(N) where N is the total number of elements stored across both stacks.
 */ 
 
 //Amortized O(1) means:
//An operation may sometimes take O(n), but when we look at a sequence of many operations together, the average cost per operation is O(1).