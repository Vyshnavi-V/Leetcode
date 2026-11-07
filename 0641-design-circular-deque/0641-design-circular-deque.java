class MyCircularDeque {
    // Queue Pattern
    int[] deque;
    int size;
    int front=-1,rear=-1;
    // Initialize deque with capacity k
    public MyCircularDeque(int k) {
        deque = new int[k];
        size=k; 
    }
    
    public boolean insertFront(int value) {
        if(isFull()){  // If deque is full, insertion is not possible
            return false;
        }
        // If deque is empty, initialize both pointers to 0
        else if(front==-1 && rear==-1){
            front=0;
            rear=0;
            deque[front]=value;
        }
        // If front is at index 0, move it to the last index
        else if(front==0){
            front=size-1;
            deque[front]=value;
        }
        // Otherwise, move front one position backward and insert the element
        else{
            front--;
            deque[front]=value;
        }
    return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){ // If deque is full, insertion is not possible
            return false;
        }
        // If deque is empty, initialize both pointers to 0
        else if(front==-1 && rear==-1){ 
            front=0;
            rear=0;
            deque[rear]=value;
        }
        // If rear is at the last index, move it to index 0 and insert the element
        else if(rear==size-1){      
            rear=0;
            deque[rear]=value;
        }
        // Otherwise, move rear one position forward and insert the element
        else{     
            rear++;
            deque[rear]=value;
        }
    return true;
    }
    
    public boolean deleteFront() {
         // If deque is empty, deletion is not possible
        if(isEmpty()){
            return false;
        }
         // If only one element exists, reset both pointers to -1
        else if(front==rear){
            front=-1;
            rear=-1;

        }
       // If front is at the last index, move it to index 0
        else if(front==size-1){
            front=0;
        }
        // Otherwise, move front one position forward
        else{
            front++;
        }
    return true;
    }
    
    public boolean deleteLast() {
        // Delete an element from the rear of the deque
        if(isEmpty()){
            return false;
        }
        // If only one element exists, reset both pointers to -1
        else if(front==rear){
            front=-1;
            rear=-1;
        }
        // If rear is at index 0, move it to the last index
        else if(rear==0){
            rear=size-1;
        }
        // Otherwise, move rear one position backward
        else{
            rear--;
        }
    return true;
    }
    
    public int getFront() {
        // If deque is not empty, return the front element
        if(!isEmpty()){
            return deque[front];

        }
    return -1;
    }
    
    public int getRear() {
        // If deque is not empty, return the rear element
        if(!isEmpty()){
            return deque[rear];

        }
    return -1;
    }
    
    public boolean isEmpty() {
        // Both pointers are -1 when deque is empty
        if(front==-1 && rear==-1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        // Condition 1: Front is at index 0 and rear is at last index
        // Condition 2: Rear is immediately before front (circularly)
        if(front==0 && rear==size-1||front==rear+1){
            return true;
        }
    return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

 /*Complexity:
 Time Complexity:  O(1) strictly for all operations (insertFront, insertLast, 
                     deleteFront, deleteLast, getFront, getRear, isEmpty, isFull).
 Space Complexity: O(K) auxiliary space allocated for the internal array of capacity K.
 */