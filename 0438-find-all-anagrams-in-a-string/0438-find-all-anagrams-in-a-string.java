class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       // Sliding Window + Frequency Map approach
       // Frequency arrays to track character counts ('a'-'z') in s and p string
       int[] sArr = new int[26];
       int[] pArr = new int[26];
       ArrayList<Integer> myList = new ArrayList<>();
       //Update the freq count in pArr 
       for(int i=0;i<p.length();i++){
        pArr[p.charAt(i) - 'a']++;
       }
       // -----Sliding window----- Expanding----
        // Update the freq count in sArr 
        for(int i=0;i<s.length();i++){
            // Add current character to  frequency
            sArr[s.charAt(i) - 'a']++;
            // Shrink window from the left if window size exceeds p.length()---condition violates
            if(i>=p.length()){
                sArr[s.charAt(i-p.length()) - 'a']--;
            }
            //Compare the array.. if equal add the index to the list!
            if(Arrays.equals(sArr,pArr)){
                myList.add(i-p.length() + 1);
            }

        }
    return myList;
    

    }
}
