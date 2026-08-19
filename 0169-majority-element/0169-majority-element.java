class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int threshold=nums.length/2;
        for(int i=0;i<nums.length;i++){
            int count = map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],count); //  Update the map with the incremented count
            // If any number's count exceeds n / 2, return it .
            if(count > threshold){
                return nums[i];
            }
        }
    return -1;
       
    }
}