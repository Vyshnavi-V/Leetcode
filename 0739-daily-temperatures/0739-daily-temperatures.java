class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Monotonic Stack Template
        int length=temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[length];
        for(int i=length-1;i>=0;i--){
            // Pop days that are colder or equal to current day
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
                
            }
            if(!stack.isEmpty()){
                // Distance = future warmer index (stack.peek()) - today's index (i)
                arr[i]=stack.peek()-i;
            }
            // Push current day's INDEX
            stack.push(i);
        }
    return arr;
    }
}