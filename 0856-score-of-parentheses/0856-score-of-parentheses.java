class Solution {
    public int scoreOfParentheses(String s) {
        // Stack - Paranthese and Scoring Pattern
       Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // Base score for the current level
        for(char ch:s.toCharArray()){
             if(ch=='('){ // Opening '(' → start a new level
                stack.push(0); // Push 0 as the initial score for this level
             }
             // Closing ')' → complete the current pair
             else{
                int val = stack.pop(); // Get the score inside the current parentheses
                // Calculate score:
                // ()       → 1
                // (A)      → 2 * score(A)
                int score = Math.max(2*val,1);
                stack.push(score+stack.pop()); // Add this score to the previous level
             }
        }
    return stack.pop();  // Final score is at the top of the stack
    }
}