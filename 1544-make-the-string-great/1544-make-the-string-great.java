class Solution {
    public String makeGood(String s) {
        // Stack Undo Pattern
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            // If current character is the same letter with opposite case
            if(!stack.isEmpty() && Math.abs(ch-stack.peek())==32){
                stack.pop(); // Remove the bad pair
             }
             else{
                stack.push(ch); // Otherwise, push the character to the stack
             }
        }
        StringBuilder sb = new StringBuilder();
        // Pop characters and insert at beginning to maintain original order
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
    return sb.toString();
    }
}

/*Math.abs(ch - stack.peek()) == 32
       ASCII difference between upper and lower case = 32
       'a' = 97    'A' = 65
       'b' = 98    'B' = 66
        Math.abs('a' - 'A') == 32  → true
        Math.abs('b' - 'B') == 32  → true
        Math.abs('a' - 'B') == 32  → false
 */