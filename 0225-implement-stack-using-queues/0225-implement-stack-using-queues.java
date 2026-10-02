class MyStack {
    // Stack Based Design Pattern
    // Two queues are used to implement a stack
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    public MyStack() {
        // If you assign new ArrayDeque<>() when declaring the variables, the constructor body can be completely empty and it is valid
    }
    
    public void push(int x) {
       q1.add(x);
    }
    
    public int pop() {
        // Move all elements except the last one to q2, The last element is the Stack's top
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int poll = q1.poll(); // Remove and store the last element
        // Swap references so q1 holds all elements and q2 becomes the empty buffer again
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    return poll;
    }
    
    public int top() {
        // Move all elements except the last one to q2
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int top = q1.peek(); // Last element is the Stack's top
        q2.add(q1.poll()); // Also move this last element to q2 so no data is discarded
        // Swap references so q1 holds all elements and q2 becomes the empty buffer again
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    return top;
    }
    
    public boolean empty() {
        return q1.isEmpty() ; // q1 contains all the stack elements
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
    push(x): O(1) — Direct enqueue to q1.
    pop():   O(N) — Shifts (N - 1) elements to q2, polls 1 element, swaps references.
    top():   O(N) — Shifts (N - 1) elements, inspects 1 element, shifts it, swaps references.
    empty(): O(1) — Checks if active queue q1 is empty.
    Space Complexity: O(N) — Stores N total elements across both queues.
 */
 