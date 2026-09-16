class Solution {
    public int calculate(String s) {
        // Stack Pattern - Expression Evaluation
        char op='+'; // Track the preceding operator (default is '+' for the very first number)
        int num=0;
        Deque<Integer> stack = new ArrayDeque<>();
        // Loop runs to s.length() so the trailing '+' forces the final number to be processed ("+3+2*2+")
        for(int i=0;i<=s.length();i++){
            // Append a virtual '+' at the end to trigger evaluation of the last number
            char ch = i==s.length()? '+': s.charAt(i);
            if(Character.isDigit(ch)){
                // 1. Build multi-digit numbers digit by digit
                num = num*10 + (ch - '0');
            }
            // 2. Encountered an operator
            else if(ch!=' '){
                // Apply the PREVIOUS operator ('op') to 'num'
                if(op=='+'){
                    stack.push(num);
                }
                else if(op=='-'){ // Push as negative to turn subtraction into addition
                    stack.push(-num);
                }
                else if(op=='*'){
                    stack.push(stack.pop()*num);
                }
                else{
                    stack.push(stack.pop()/num);
                }
            op=ch; // Update 'op' to current operator 
            num=0; //reset the number builder
            }
        }

        int ans=0;
        // Sum all evaluated terms remaining in the stack
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
    return ans;
    }
}