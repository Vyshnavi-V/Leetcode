class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxArea=0;
        while(left<right){
            int  length = Math.min(height[left],height[right]);
            int width = right - left;
            int currentArea = length*width;
            if(height[left] < height[right]){
                left++;
            }
            else{ //height[left]>height[right]]
                right--;
            }
            maxArea=Math.max(maxArea,currentArea);
        }
        return maxArea;
    }
}