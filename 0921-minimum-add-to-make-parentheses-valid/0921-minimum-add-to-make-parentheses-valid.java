class Solution {
    public int minAddToMakeValid(String s) {
        // Optimized Space Complexity from O(N) to O(1)  using variables instead of Stack
        int openCount=0,closeCount=0;
        for(char ch:s.toCharArray()){
           if(ch=='('){
            openCount++; // An opening bracket is available.
           }
           else if(ch==')' && openCount>0){
            openCount--; // Incoming ')' successfully matches and closes an earlier '('
           }
           else{ 
            closeCount++; // Incoming ')' has no available '(' to pair with
           }
        }
    // missing ')' for leftover '(' + missing '(' for premature ')'
    return openCount+closeCount;
    }
}

/* Complexity:
     Time Complexity:  O(N) — Single linear scan over the string of length N.
     Space Complexity: O(1) — Constant extra space; eliminates O(N) stack memory overhead.
*/