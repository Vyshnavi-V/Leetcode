class Solution {
    public int countSubstrings(String s) {
        // two pointers
        int length=s.length();
        int totalCount=0;
        // Iterate through each character index
        for(int i=0;i<length;i++){
            // Case 1: Count odd-length palindromes centered at index 'i' (e.g., "a", "aba")
            totalCount+=myFun(s,i,i); 
            // Case 2: Count even-length palindromes centered between 'i' and 'i+1' (e.g., "aa", "abba")
            totalCount+=myFun(s,i,i+1);
        }
    return totalCount;
    }
    private int myFun(String s,int left,int right ){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
    // Return the count of palindromes found from this center
    return count;
    }
    
}