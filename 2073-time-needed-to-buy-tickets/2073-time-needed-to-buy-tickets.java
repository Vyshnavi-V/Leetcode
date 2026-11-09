class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // Queue Pattern
        int size=tickets.length;
        int front=0;
        int count=0;
        // Loop runs until person k has bought all their needed tickets
        while(tickets[k]>0){
            // Person has already bought all their tickets; skip them
            if(tickets[front]==0){
                front=(front+1)%size; // Skip this person and move to the next person
            }
            else{
                tickets[front]=tickets[front]-1; // Sell one ticket to the current person
                front=(front+1)%size; // Move to the next person in circular order
                count++; // Increment time because one ticket was purchased
            }
        }

    return count;
    }
}
// Complexity:
// Time Complexity:  O(N * M), where N = tickets.length and M = tickets[k].
//                   In the worst case, we cycle through the line M times.
//  Space Complexity: O(1) auxiliary space as modifications happen in-place.