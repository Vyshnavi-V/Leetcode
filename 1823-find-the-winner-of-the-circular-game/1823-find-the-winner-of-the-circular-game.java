class Solution {
    public int findTheWinner(int n, int k) {
        // LIST PATTERN
        List<Integer> list = new ArrayList<>();
        int count=1; // Keeps track of the current counting position
        // Add friends numbered from 1 to n
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int i=0;// Starts counting from the first index
        // Continue until only one friend remains
        while(list.size()>1){
            if(count==k){ // Remove the friend who reaches the kth count
                list.remove(i);
                count=1;  // Reset count for the next round
                
            }
            else{
                i=(i+1)%(list.size()); // Move to the next friend in circular order
                count++; // Increment the counting position
            }
        }
    return list.get(0); // Return the last remaining friend
    }
}

/* Time Complexity: O(n²) – Removing an element from an ArrayList takes O(n) in the worst case, and -  we perform up to n-1 removals.
   Space Complexity: O(n) – The ArrayList stores all n friends.
*/