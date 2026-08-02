class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        // Sliding Window + HashMap
        int length=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen=-1;
        int left=0;
        for(int right=0;right<length;right++){
            // Expanding
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            // Shrinking If window has more than K unique characters, shrink from the left
            while(map.size()>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            // Only update maxLen when the window contains EXACTLY K unique characters
            if(map.size()==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
        }
   
    return maxLen;
    
    
    }
}
