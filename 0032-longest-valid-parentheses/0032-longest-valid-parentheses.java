class Solution {
    public int longestValidParentheses(String s) {
        // STACK - Parantheses Pattern
        int max=0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // Base reference boundary before the start of the string
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i); // Push index of  opening bracket
            }
            else{
                // Closing bracket encountered: pop the top index (either a matching '(' or previous boundary)
                stack.pop(); 
                // No matching '(' exists for this ')'; it becomes the new starting boundary
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    // Valid substring So keep track of the maximum substring found
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
    return max;
    }
    
}
/*
When ')' arrives:
1. Pop the top element (attempting to match an open '(').
2. If the stack becomes empty:
This ')' had no matching '(' available. It becomes the NEW invalid boundary,
so we push its index onto the stack.
3. If the stack is NOT empty:
    A valid substring formed 
    
Time Complexity:O(N)
Space Complexity:O(N) 
*/