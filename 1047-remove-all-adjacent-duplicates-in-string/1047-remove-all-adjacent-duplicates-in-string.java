class Solution {
    public String removeDuplicates(String s) {
        // Using StringBuilder as a stack
         StringBuilder sb = new StringBuilder();
         for(char ch:s.toCharArray()){ 
            // Get index of last character from stringbuilder
            int length = sb.length()-1;
            // If last character of stringbuilder is same as current character of s 
            if(length>=0 && sb.charAt(length)==ch){
                sb.deleteCharAt(length); // Remove the last character
            }
            else{  
                sb.append(ch); // Add current character at the end
            } 
         }
    return sb.toString(); // Convert StringBuilder to String
    }
}