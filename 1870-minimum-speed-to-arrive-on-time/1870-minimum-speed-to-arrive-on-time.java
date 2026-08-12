class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        // Binary Search On Answers Approach
        int low=1; // Minimum speed is 1km/hr
        int high=10000000; //Maximum speed: 10^7 km/h(as mentioned in the QS)
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(myFun(dist,hour,mid)){
                ans=mid; // Valid speed found
               high=mid-1; // Search left half for a lesser valid speed
            }
            else{
                low=mid+1; // Speed is less, increase speed (search right)
            }
        }
    return ans;
    }
    //myFun - Calculate the current 'speed' and checks if it is <= 'hour'
    private boolean myFun(int[] dist,double hour,int speed){
        double hrsNeeded=0.0;
        for(int i=0;i<dist.length;i++){
            // Final train: Calculate exact decimal time (no waiting required after arrival)
            if(i==dist.length-1){
                 hrsNeeded+=(double)dist[i]/speed;
            }
            // Intermediate trains: Must wait for the next integer hour mark (Math.ceil(dist[i]/speed))
            else{
                hrsNeeded+=(dist[i]+speed-1)/speed;
            }
        }
    return hrsNeeded<=hour;
    }

}