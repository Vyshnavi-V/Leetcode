class Solution {
    public String minRemoveToMakeValid(String s) {
        // Stack + Greedy Pattern
        Stack<Integer> stack = new Stack<>(); // Stack stores indices of unmatched '(' characters
        StringBuilder sb = new StringBuilder(); // Builds the string while marking invalid ')' with '#'.
        StringBuilder finalSb = new StringBuilder(); // Stores the final valid string without '#'.

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(i); // Store the index of the opening parenthesis.
                sb.append(ch); // append to sb
            }
            else if(ch==')'){
                if(stack.isEmpty()){ // No matching '(' exists, so mark this ')' as invalid.
                    sb.append("#");
                }
                else{ // A matching '(' exists, so this ')' is valid.
                    sb.append(ch);
                    stack.pop();
                }
            }
            else{ // Keep all non-parenthesis characters unchanged.
                sb.append(ch);

            }
        }
        //  Mark all remaining unmatched '(' as invalid.
        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(),'#');  // Replace the character at the stored index with '#'
        }
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch!='#'){ //  Build the result by skipping invalid characters.
                finalSb.append(ch);
            }
        }
    return finalSb.toString();
        
    }
}

/*
WHY USE '#'?
- '#' is a temporary marker for an invalid parenthesis.
- It lets us mark invalid characters without deleting them immediately.
- This keeps all indices unchanged while we process the string.
- In the final pass, we skip '#' and copy the remaining characters.

TIME COMPLEXITY: O(n)
- Each character is processed a constant number of times.

SPACE COMPLEXITY: O(n)
- The stack and StringBuilders can each store up to O(n) elements.
*/