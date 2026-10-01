class MyStack {
    // Two queues are used to implement a stack
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public MyStack() {
        // If you assign new ArrayDeque<>() when declaring the variables, the constructor body can be completely empty and it is valid
    }
    
    public void push(int x) {
        // Move all elements from queue1 to queue2, This makes space for the new element
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(x); // Add new element to queue1
        // Move all elements back to queue1, New element comes to the front
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }
    
    public int pop() {
        return queue1.poll(); // Remove and return the front element
    }
    
    public int top() {
        return queue1.peek(); // Return the front element
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty(); // Stack is empty when both queues are empty
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 /*Complexity:
    Time Complexity:
    push(x): O(N) — Transfers all N elements back and forth between queues.
    pop():   O(1) — Direct dequeue from the front of queue1.
    top():   O(1) — Inspects the front of queue1.
    empty(): O(1) — Simple empty check.
    Space Complexity: O(N) — Stores N elements across the two queues.
 */