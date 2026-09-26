class Solution {
    public int minLength(String s) {
        // StringBuilder as Stack Pattern
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            // Get index of the last character
            int length = sb.length()-1;
             // If current character is B and last char in sb is A, "AB" is a removable pair
            if(length>=0 && ch=='B' && sb.charAt(length)=='A'){
                sb.deleteCharAt(length);
            }
            // If current character is D and last char in sb is C, "CD" is a removable pair
            else if(length>=0 && ch=='D' && sb.charAt(length)=='C'){
                sb.deleteCharAt(length);
            }
             // If no removable pair, then append the character to sb
            else{
                sb.append(ch);
            }
            
        }
    return sb.length(); // Return the length
    }
}