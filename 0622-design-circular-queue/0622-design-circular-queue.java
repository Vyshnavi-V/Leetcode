class MyCircularQueue {
    int[] queue; // Initializes the circular queue with capacity k.
     int front=-1,rear=-1;
    int size; // Maximum capacity of the queue
    public MyCircularQueue(int k) { // Constructor: Initializes the circular queue with capacity k
        size=k;
        queue=new int[k];
    }
    
    public boolean enQueue(int value) {
        // If the queue is full, insertion is not possible
        if(isFull()){
            return false;
        }
        // Move rear to the next position using circular movement
        rear=(rear+1)%size;
        queue[rear]=value; // Insert the new value at the rear position
        if(front==-1){ // If this is the first element, initialize front to 0
            front=0;
        }
    return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){ // If the queue is empty, deletion is not possible
            return false;
        }
        if(front==rear){ // If front and rear are equal, only one element is present
            front=-1;
            rear=-1;
            return true;
        }
        front=(front+1)%size; // Move front to the next position using circular movement
        return true;
    }
    
    public int Front() {
        // Check whether the queue contains any elements
        if(!isEmpty()){
            return queue[front];
        }
    return -1;   // Queue is empty
    }
     
    public int Rear() {
        // Check whether the queue contains any elements
        if(!isEmpty()){
            return queue[rear];
        }
    return -1; // Queue is empty

    }
    
    public boolean isEmpty() {
        if(front==-1 && rear==-1){ // Both pointers are -1 when the queue is empty
           return true;
        }
    return false;
    }
    
    public boolean isFull() {
        // Condition 1: Front is at index 0 and rear is at the last index
        // Condition 2: Rear is immediately before front after circular wraparound
        if(front==0 && rear==size-1 || front==rear+1){
            return true;
        }
    return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

 /*Complexity:
  - Time Complexity:  O(1) strictly for every method (enQueue, deQueue, Front, Rear, isEmpty, isFull).
  - Space Complexity: O(K) auxiliary space to allocate the internal fixed-size array.
 */