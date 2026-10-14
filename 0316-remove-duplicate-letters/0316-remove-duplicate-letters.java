class Solution {
    public String removeDuplicateLetters(String s) {
        // Stack+Greedy Pattern - Used StringBuilder instead of stack for faster operations
        StringBuilder sb = new StringBuilder();
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        // Precompute the last occurrence index for each unique character
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            lastIndex[ch-'a'] = i; //Storing last index
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            // If `ch` is already in our stack(sb), skip it. An earlier occurrence gives a better or equal prefix.
            if(visited[ch-'a']){
                continue;
            }
            // 1. sb is not empty.
            // 2. Incoming character `ch` is smaller than stack(sb) top (lexicographically better).
            // 3. Stack top appears again later in the string (current index i < lastIndex[top]).
            while(sb.length()>0 && ch<sb.charAt(sb.length()-1) 
                  && i<lastIndex[sb.charAt(sb.length()-1)-'a']){ 
                    // The last character is removed, so mark it as not visited. It can be added again later.
                    visited[sb.charAt(sb.length()-1)-'a']=false;
                    sb.deleteCharAt(sb.length()-1);
            }
            sb.append(ch); // Add current character onto the stack(sb)
            visited[ch-'a']=true;
        }
    return sb.toString();
    }
}

/*
Why Arrays instead of HashMap/HashSet?
- Only 26 lowercase letters, so arrays are sufficient.
- lastIndex stores each character's last position.
- visited tracks whether a character is already included.
- Arrays provide O(1) access with less overhead.

Time Complexity: O(n)
Space Complexity: O(1) auxiliary space (fixed-size arrays).
Output space: O(n) for StringBuilder.
*/