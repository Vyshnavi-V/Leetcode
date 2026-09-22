class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Stack Undo Pattern
        // Create a stack for each string
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch!='#'){
                stackS.push(ch); // Normal character → push into stack
            }
            else if(!stackS.isEmpty()){
                stackS.pop(); // '#' → remove previous character if stack is not empty
            }
        }
        for(char ch:t.toCharArray()){
            if(ch!='#'){
                stackT.push(ch); // Normal character → push into stack
            }
            else if(!stackT.isEmpty()){
                stackT.pop(); // '#' → remove previous character if stack is not empty
            }
        }
        return stackS.equals(stackT);  // Compare both stacks
    }
}