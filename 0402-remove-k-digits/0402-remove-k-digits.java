class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb=new StringBuilder();
        for(char ch:num.toCharArray()){
            //Case:1 Remove previous bigger digits to make the number as small as possible
            while(k>0 && sb.length()>0 && sb.charAt(sb.length()-1)>ch){
                sb.deleteCharAt(sb.length()-1);  // Remove the last digit from sb
                k--; // One digit has been removed
            }
            sb.append(ch); // Add current digit
        }
        // Case:2 If k digits are still left,remove them from the end(eg: "1234567") number in ascending order
        sb.setLength(sb.length()-k); 
        // Case:3 remove zeros
        int zeroPointer=0;
         while(zeroPointer<sb.length() && sb.charAt(zeroPointer)=='0'){
                zeroPointer++;
        } 
        
        String ans = sb.substring(zeroPointer); // Remove leading zeros
    return ans.isEmpty()?"0":ans;
    }
}
/* Complexity:
    Time Complexity: O(N) where N is num.length(). Each character is appended and deleted at most once.
    Space Complexity: O(N) auxiliary space used by StringBuilder.
  */