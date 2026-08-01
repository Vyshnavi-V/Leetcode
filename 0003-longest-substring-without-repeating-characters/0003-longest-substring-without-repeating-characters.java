class Solution {
    public int lengthOfLongestSubstring(String s) {
        //SLIDING WINDOW + HASHMAP ----- Optimized way----
        int length = s.length();
        // HashMap stores: Character |  Index of that character
        HashMap<Character,Integer> map= new HashMap<>();
        int left=0;
        int maxLen=0;
        for(int right=0;right<length;right++){
            if(map.containsKey(s.charAt(right))){
                // Jump LEFT directly past the previous occurrence of 'currentChar'.
                // Math.max guarantees 'left' never moves backwards(eg abba will fail without math.max)
                left = Math.max(left,map.get(s.charAt(right))+1);
            }
            // Update index of the currentChar
            map.put(s.charAt(right),right);
        maxLen=Math.max(maxLen,right-left+1);
        }
    return maxLen;
    }
}



/*//SLIDING WINDOW + HASHMAP
        int length=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0;
        int maxLen=0;
        //Expanding the window
        for(int right=0;right<length;right++){
           map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
           //Shrinking the window; If rightChar has a count > 1
           //// Shrink the window from the LEFT until the duplicate count drops back to 1
           while(map.get(s.charAt(right))>1){
                //Decrement the count
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
           }
        maxLen = Math.max(maxLen,right-left+1);
        }
    return maxLen;*/ 