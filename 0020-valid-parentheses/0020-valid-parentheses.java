class Solution {
    public boolean isValid(String s) {
        // Stack Pattern - Parantheses
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            // Check if the stack is non-empty and the current closing bracket matches the top opening bracket
            if(!stack.isEmpty() && (
                (ch==')' && stack.peek()=='(') ||
                (ch==']' && stack.peek()=='[') ||
                (ch=='}' && stack.peek()=='{')
                )
            ){
                stack.pop(); // Matching pair found, remove the opened bracket
            }
            else{
                stack.push(ch);  // Otherwise, push the character into stack
            }
        }
    return stack.isEmpty(); // Stack empty means all brackets are properly matched
    }
}
/* Complexity:
     Time Complexity:  O(N) — Single pass over the string with O(1) push, peek, and pop operations.
     Space Complexity: O(N) — In the worst case (e.g., "((((("), all characters are stored in the stack.
*/