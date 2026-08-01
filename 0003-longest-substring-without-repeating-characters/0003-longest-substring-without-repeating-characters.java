class Solution {
    public int lengthOfLongestSubstring(String s) {
        //SLIDING WINDOW + HASHMAP
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
    return maxLen;
    }
}