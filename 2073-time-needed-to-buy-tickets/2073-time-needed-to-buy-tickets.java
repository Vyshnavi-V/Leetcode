class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // Approach 2 (Previous Approach - Queue)
        int count=0; // Stores the total time required to finish buying tickets
        for(int i=0;i<tickets.length;i++){
             // People before or at position k
            if(i<=k){
                // These people get a chance to buy tickets in every round until person k finishes.They can buy at most tickets[k] tickets.
                count+=Math.min(tickets[i],tickets[k]);
            }
            // People after position k
            else{
                // The queue stops immediately when person k buys their final ticket. So people after k get only tickets[k] - 1 rounds.
                count+=Math.min(tickets[i],tickets[k]-1);
            }
        }
    return count;  // Return the total number of seconds taken
    }
}

/* Notes
 *  Why Two Separate Rules?
 *    Imagine tickets[k] = 3 rounds of buying:
 * 
 *    - Case A: People ahead of or at k (i <= k)
 *      They get a turn in EVERY round person k participates in:
 *      Round 1, Round 2, Round 3.
 *      -> If someone wants 2 tickets, they buy 2.
 *      -> If someone wants 10 tickets, they only get to buy 3 before k leaves.
 *      Formula: Math.min(tickets[i], tickets[k])
 * 
 *    - Case B: People behind k (i > k)
 *      They only get a turn if person k has NOT finished yet.
 *      In person k's final round (Round 3), person k buys their ticket, 
 *      the condition is met, and the queue IMMEDIATELY STOPS.
 *      People behind k never get a turn in that final round!
 *      They participate in at most (tickets[k] - 1) rounds.
 *      Formula: Math.min(tickets[i], tickets[k] - 1)
 * 
 * ============================================================================
 * COMPLEXITY ANALYSIS:
 * ============================================================================
 * - Time Complexity:  O(N), where N is tickets.length.
 *                     Single pass through the array with O(1) arithmetic operations.
 * - Space Complexity: O(1) auxiliary space.
 *                     Operates strictly using primitive variables without extra buffers.
 */