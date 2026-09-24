class Solution {
    public String removeDuplicates(String s) {
        // STACK - UNDO OPERATION PATTERN
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            // If current character matches stack top, remove the duplicate pair
            if(!stack.isEmpty() && ch==stack.peek() ){
                stack.pop();
            }
            else{
                // Otherwise, add the character to stack
                stack.push(ch);
            }
        }
        StringBuilder str = new StringBuilder();
        // Pop characters and insert at beginning because stack gives them in reverse order
        while(!stack.isEmpty()){
            str.insert(0,stack.pop());
        }
    return str.toString();
    }
}