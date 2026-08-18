class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int rev=0;
        while(x>0){
            int digit=x%10; // Extract the last digit
            rev=(rev*10)+digit; // Append digit to reversed number
            x=x/10; // Remove the last digit from x
        }
        if(rev==temp){
            return true;
        }
        else{
            return false;
        }
    }
}