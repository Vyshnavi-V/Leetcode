class Solution {
    public boolean isPalindrome(String s) {
        // Two pointer approach
        int length=s.length();
        boolean flag=true;
        // Convert entire string to lowercase to handle case-insensitivity
        s=s.toLowerCase();
        int left=0;
        int right=length-1;
        while(left<right){
            // Skip non-alphanumeric characters from the left
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
        
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                flag=false;
                break;
            }
        }
    return flag;
    }
}