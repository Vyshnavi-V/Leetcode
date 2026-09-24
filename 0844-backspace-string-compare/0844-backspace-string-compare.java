class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Follow up: Can you solve it in O(n) time and O(1) space?
        int skipS=0,skipT=0;// Count how many characters should be skipped
        // Start from the end of both strings
        int i=s.length()-1;
        int j=t.length()-1;
        // Continue until both strings are completely checked
        while(i>=0 || j>=0){
            // Process string S from right to left
            while(i>=0){
                 // '#' means the previous character must be deleted
                if(s.charAt(i)=='#'){ 
                    skipS++;
                    i--;
                }
                // Skip the character because it is deleted
                else if(skipS>0){
                    skipS--;
                    i--;
                }
                // Found a valid character
                else{  
                    break;
                }
            }
            // Process string T from right to left
            while(j>=0){
                // '#' means the previous character must be deleted
                if(t.charAt(j)=='#'){
                    skipT++;
                    j--;
                }
                // Skip the character because it is deleted
                else if(skipT>0){
                    skipT--;
                    j--;
                }
                // Found a valid character
                else{
                    break;
                }
            }
            // Compare the valid characters
            if(i>=0 && j>=0){
                // Characters are different → strings are not equal
                if(s.charAt(i)!=t.charAt(j)) {
                    return false;
                }
            }
            else{
                // Checking the length - One string still has a character → not equal
            if(i>=0 || j>=0){  // eg i at index 0 and j at index -1.. then this if block will be executed and it will return false
                return false;
            }
            }
            
            // Move to the next character from right to left
            i--;
            j--;
            
        }
        // All valid characters matched
    return true;
    }
}