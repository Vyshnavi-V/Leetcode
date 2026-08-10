class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       //Binary Search Optimal Approach
       int low=1;
       int high=0;
       // Find max element in piles to set the upper search boundary
       for(int p:piles){
        high=Math.max(high,p);
       }
       int ans=high;
       while(low<=high){
            int mid=low+(high-low)/2;
            //Check if speed 'mid' allows Koko to finish eating within 'h' hours
            if(myFun(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            
       }
    return ans;
    }
    //Function to check if the eating speed "kSpeed" is sufficient
    private boolean myFun(int[] piles,int h,int kSpeed){
        long hours=0; // MUST be long to prevent integer overflow for large test cases
        for(int p:piles){
            // Formula for ceil without floating point division --faster that type conversion formula
            //(int)Math.ceil((double)p/kSpeed)
            hours+=(p+kSpeed-1)/kSpeed;
        }
    return hours<=h;
    }
}