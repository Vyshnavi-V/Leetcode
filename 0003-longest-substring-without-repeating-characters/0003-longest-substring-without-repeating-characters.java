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



