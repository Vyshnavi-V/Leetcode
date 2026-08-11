class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Binary Search On Answers
        int max=0,sum=0;
        for(int w:weights){
            max=Math.max(max,w);  //Minimum capacity must fit the heaviest item
            sum+=w;               // Maximum capacity is shipping everything in 1 day
        }
        int low = max;
        int high = sum;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(myFun(weights,days,mid)){
                ans=mid; // Valid capacity found, record candidate
                high=mid-1; // Search left half for a smaller valid capacity
            }
            else{
               low=mid+1;   // Capacity too small, increase capacity (search right)
            }
        }
    return ans;
        
    }
    //myFun - Counts the number of days needed to ship all items
    private boolean myFun(int[] weights,int days,int capacity){
        int sum=0,daysNeeded=1;
        for(int w:weights){
            sum+=w;
           // If total weight exceeds ship's max capacity, 'w' CANNOT fit on today's ship!
            if(sum>capacity){
                daysNeeded++; // Ship today's load and move to a NEW day
                sum=w;        // Put item 'w' as the VERY FIRST item on the new day's ship
            }
        }
        return daysNeeded<=days;
    }
}