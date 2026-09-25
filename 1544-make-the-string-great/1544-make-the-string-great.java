class Solution {
    public String makeGood(String s) {
        // StringBuilder as Stack
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            int length = sb.length()-1;
            // Current ch and the last element in stringbuilder are the same letter with opposite case.
            if(length>=0 && Math.abs(ch - sb.charAt(length))==32){
                sb.deleteCharAt(length);
            }
            else{
                sb.append(ch); // If No match, append the current character to the string builder
            }

        }
    return sb.toString();
    }
}

/*Math.abs(ch - sb.charAt(length)) == 32
       ASCII difference between upper and lower case = 32
       'a' = 97    'A' = 65
       'b' = 98    'B' = 66
        Math.abs('a' - 'A') == 32  → true
        Math.abs('b' - 'B') == 32  → true
        Math.abs('a' - 'B') == 32  → false
 */