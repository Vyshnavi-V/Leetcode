class Solution {
    public String minRemoveToMakeValid(String s) {
        // Solved the problem using Stack+Greedy Pattern also - Check it
        // Using variable counters instead of Stack - Another method
        int open=0,close=0;
        StringBuilder sb =new StringBuilder();
        StringBuilder ans =new StringBuilder();

        // For Open ( -  Remove all invalid ')' from Left to Right
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
                sb.append(ch);
            }
            else if(ch==')'){ // Keep ')' only if there is an unmatched '(' before it
              if(open>0){
                open--;
                sb.append(ch);
              } 
              //  open == 0, meaning this ')' has no pair; skip it
            }
            else{
                sb.append(ch); // Lowercase English letters are always valid
            }
        }
        // For Close  Remove all unmatched '(' from Right to Left
        for(int i=sb.length()-1;i>=0;i--){
            char ch=sb.charAt(i);
            if(ch==')'){
                close++;
                ans.append(ch);
            }
            else if(ch=='('){ // Keep '(' only if there is a corresponding ')' after it
              if(close>0){
                close--;
                ans.append(ch);
              } 
              // close == 0, meaning this '(' was never closed; skip it
            }
            else{
                ans.append(ch);
            }
        }
    return ans.reverse().toString(); // Reverse to restore original order
    }
}
/*
TIME COMPLEXITY: O(n)
- Two passes through the string, each taking O(n).

SPACE COMPLEXITY: O(n)
- StringBuilder objects store up to O(n) characters.
- The counters use O(1) auxiliary space.
*/