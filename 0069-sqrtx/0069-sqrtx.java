class Solution {
    public int mySqrt(int x) {
        // Binary Search Approach
        //Edge Case: sqrt(0) = 0 and sqrt(1) = 1
        if(x<2){
            return x;
        }
        // Use 'long' to prevent 64-bit overflow during mid * mid calculations
        long left=1;
        long right=x/2;
        while(left<=right){
            long mid = left+(right-left)/2;
            long square =  mid*mid;
            if(square == x){
                return (int)mid;
            }
            if(square<x){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        // When (left > right), 'right' holds floor(sqrt(x))
        return (int)right;
    }
}