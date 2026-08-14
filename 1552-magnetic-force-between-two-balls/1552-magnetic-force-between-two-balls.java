class Solution {
    public int maxDistance(int[] position, int m) {
        // Binary Search On Answers Pattern
        Arrays.sort(position);
        int length=position.length;
        int low=1;
        int high=position[length-1] - position[0];// Maximum possible distance 
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(myFun(position,m,mid)){
                ans=mid; // Save the current possible distance
                low=mid+1; //Try to find a LARGER distance (search RIGHT)
            }
            else{
                high=mid-1;
            }
        }
        
    return ans;
    }
    // Helper Function,checks if at least 'm' balls can be placed with a minimum gap of 'dist'.
    private boolean myFun(int[] position,int m,int dist){
        int countBalls=1; // placed the 1st ball at the very first basket arr[0]
        int last=position[0];// Track of the most recently placed ball
        for(int i=1;i<position.length;i++){
            if((position[i] - last)>=dist){
                countBalls++; 
                last=position[i]; // Update the position of the last placed ball
            }
        }
    return countBalls>=m; // Return true if we placed 'm' or more balls successfully
    }
}

/*
         * =========================================================================
         * WHY WE MUST SORT THE ARRAY:
         * -------------------------------------------------------------------------
         * 1.  Baskets are located along a 1D line. The greedy
         *    strategy places balls sequentially from left to right.
         * 
         * 2. What happens without sorting? :
         *    Suppose unsorted position = [1, 10, 2, 7, 5], m = 3 balls, target gap = 5.
         *    - Ball 1 placed at index 0 -> basket 1  (last = 1, count = 1)
         *    - Ball 2 placed at index 1 -> basket 10 (|10 - 1| = 9 >= 5 -> count = 2)
         *    - Ball 3 placed at index 2 -> basket 2  (|2 - 10| = 8 >= 5 -> count = 3)
         *    
         *    => The code says "valid" because countBalls = 3 >= 3.
         *    => BUT IN REALITY: Ball 1 is at position 1 and Ball 3 is at position 2!
         *       The actual distance between them is |2 - 1| = 1, which violates the
         *       required minimum distance of 5.
         * 
         * 3. What sorting guarantees:
         *    Sorted position = [1, 2, 5, 7, 10].
         *    Because positions strictly increase:
         *    position[i] >= last >= all previously placed balls.
         *    If (position[i] - last >= dist), then position[i] is GUARANTEED to be
         *    even further from every earlier ball. You only ever need to check 'last'!
         * =========================================================================
         */