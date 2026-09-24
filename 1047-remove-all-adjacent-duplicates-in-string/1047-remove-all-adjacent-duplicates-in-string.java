class Solution {
    public String removeDuplicates(String s) {
        // Using StringBuilder as a stack
         StringBuilder sb = new StringBuilder();
         for(char ch:s.toCharArray()){ 
            // If last character of stringbuilder is same as current character of s 
            if(sb.length()-1>=0 && sb.charAt(sb.length()-1)==ch){
                sb.deleteCharAt(sb.length()-1); // Remove the last character
            }
            else{  
                sb.append(ch); // Add current character at the end
            } 
         } 
    return sb.toString(); // Convert StringBuilder to String
    }
}