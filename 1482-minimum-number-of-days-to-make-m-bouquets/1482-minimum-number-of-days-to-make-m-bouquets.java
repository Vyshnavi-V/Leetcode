class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Binary Search On Answers Pattern
        
        // EDGE CASE:If needed flowers (m*k) exceed the total flowers available in the garden, return -1.
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int max=0,min=Integer.MAX_VALUE;
        for(int b:bloomDay){
            max=Math.max(max,b);
            min=Math.min(min,b);
        }
        int low=min;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(myFun(bloomDay,m,k,mid)){
                ans=mid; // Save the current possible day
                high=mid-1;  //Try to find an EARLIER valid day (search LEFT)
            }
            else{
                low=mid+1;
            }
        }
    return ans;
    }
    //Helper Fun Checks if we can form at least 'm' bouquets of 'k' adjacent flowers on or before 'minDays'.
    private boolean myFun(int[] bloomDay,int m,int k,int minDays){
        int kCount=0,mCount=0; // Tracks adjacent bloomed flowers and total completed bouquets.
        for(int b:bloomDay){
           if(b<=minDays){   // instead of taking (Math.ceil(b/minDays))
            kCount++;
                if(kCount==k){  // When we collect 'k' adjacent flowers, form 1 complete bouquet
                mCount++;
                kCount=0; // Reset bloomedFlower count to start counting for the next bouquet
                }
           }
           else{ // Flower has not bloomed yet -- breaks the chain of adjacency
            kCount=0;
           }
           
        }
        return mCount>=m; // Return true if we formed at least 'm' bouquets
    }
}