class Solution {
    public int minAddToMakeValid(String s) {
        // Stack Pattern
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            // Check if current ')' pairs with a previously unmatched '(' on top
            if(!stack.isEmpty() && (ch==')' && stack.peek()=='(')){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
    // Each leftover character in the stack requires exactly one added counterpart
    return stack.size(); 
    }
}
/* Complexity:
     Time Complexity:  O(N) — Single pass over the string; push and pop operate in O(1) time.
     Space Complexity: O(N) — In the worst-case (no matching pairs, e.g., "((((" or "))))" the stack stores all N characters.
*/