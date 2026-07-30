class Solution {
    public String longestPalindrome(String s) {
        int length=s.length();
        // Track the starting and ending indices of the longest palindrome found
        int start=0,end=0;
        // Iterate through each character
        for(int i=0;i<length;i++){
            // Case 1: Check odd-length palindromes centered at character 'i' (e.g., "aba")
            int oddLength=myFun(s,i,i);
            // Case 2: Check even-length palindromes centered between 'i' and 'i+1' (e.g., "abba")
            int evenLength=myFun(s,i,i+1);
            // Get the longer of the two palindrome lengths found at center 'i'
            int max=Math.max(oddLength,evenLength);
            // If we found a palindrome longer than our current best (end - start)
            if(max > (end-start)){
                // Calculate the new start index relative to center 'i'
                start=i-(max-1)/2;
                // Calculate the new end
                end=i+max/2;
            }
        }
            // return the longest palindromic substring
            return s.substring(start,end+1);
    }
    private int myFun(String s, int left,int right){
        // Expand outward as long as pointers are within bounds AND characters match
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            
            left--;
            right++;
        }
    // Valid length = right - left - 1
    return right-left-1;
    }
}