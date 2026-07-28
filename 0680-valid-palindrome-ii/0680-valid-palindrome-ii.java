class Solution {
    public boolean validPalindrome(String s) {
        //Two pointer Approach
        int length=s.length();
        int left=0;
        int right=length-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                // Try two possibilities:
                // 1. Skip the character on the left (myFun with left + 1)
                // 2. Skip the character on the right (myFun with right - 1)
                // If either branch results in a valid palindrome, return true
                return myFun(s,left+1,right) || myFun(s,left,right-1);
            }
            left++;
            right--;
        }
    // If loop completes without mismatch, it's already a valid palindrome
    return true;    
    }
    //function
    private boolean myFun(String s, int left, int right){
        while(left<right){
            // If any characters in the remaining substring don't match, deletion fails
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
    return true;
    }

}