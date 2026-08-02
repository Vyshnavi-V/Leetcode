class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Sliding window
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
          int count=0;
        // Edge Case:
        if(s1.length()>s2.length()){
            return false;
        }
        //Update the freq count in s1Arr 
        for(int i=0;i<s1.length();i++){
            s1Arr[s1.charAt(i) - 'a']++;
        }
        //Update the freq count in s2Arr 
        for(int i=0;i<s2.length();i++){
            // Expanding--- Add current character count to  frequency
            s2Arr[s2.charAt(i) - 'a']++;

            // Shrink window from the left if window size exceeds s1.length()---condition violates
            if(i>=s1.length()){
                s2Arr[s2.charAt(i-s1.length()) - 'a']--;
            }
            //Compare the arrays
            if(Arrays.equals(s1Arr,s2Arr)){
                return true;
            }

        }
      
    return false;    
    }
}