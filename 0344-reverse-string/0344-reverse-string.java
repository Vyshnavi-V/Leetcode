class Solution {
    public void reverseString(char[] s) {
        int length=s.length;
        char[] output = new char[length];
        // Loop only through the first half of the array.
        // If we iterate through the full array, we would end up swapping elements back to their original positions!
        for(int i=0;i<length/2;i++){
            char temp=s[i];
            // Move the corresponding element from the back to the front position(s[length-1-1] ---> gives you the mirror index)
            s[i]=s[length-1-i];
            s[length-1-i]=temp;
        }

        /*Two pointer approach
        int left=0; 
        int right=length-1;
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        } 
        */
        
    }
}