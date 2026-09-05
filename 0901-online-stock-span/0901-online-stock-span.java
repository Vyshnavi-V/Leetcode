class StockSpanner {
    // Stack stores pairs: [price, index]
    // index 0 -> the stock price
    // index 1 -> the day index when that price occurred (0, 1, 2, ...)
    private Deque<int[]> stack;
    // Tracks the current day index (starts at 0, goes to 1, 2, 3...)
    private int index;
    public StockSpanner() {
      stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int ans;
        // Pop all previous days with price <= today's price
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            stack.pop();
        }
        if(stack.isEmpty()){
            // Today is higher than all past days
            ans = index+1;
        }
        else{
            // Span =  today's day - previous strictly higher day's index
            ans = index - stack.peek()[1];
        }
        // Save today's [price, index] and move to next day
        stack.push(new int[]{price,index});
        index++;
    return ans;
    }
}


/* NOTES:
    1. private means stack and index can be used only inside the StockSpanner class; they are kept hidden from outside code.
    2. Constructor StockSpanner() runs automatically when new StockSpanner() creates the object and initializes the stack.
    3. obj refers to that created object, so obj.next(price) calls the next() method using the same stack and index.
    4. Deque<int[]> stack is a stack where each element is an integer array like [price, index], e.g. [100, 0] means price = 100 on day 0.

*/

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */