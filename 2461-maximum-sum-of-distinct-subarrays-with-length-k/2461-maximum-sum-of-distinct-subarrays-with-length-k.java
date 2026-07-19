class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        //Sliding Window Approach ------------HashMap Technique-------------------
        int length=nums.length;
        int left=0;
        long sum=0;
        long maxCount=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right=0;right<length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            sum+=nums[right];
// If the window size exceeds 'k', remove the leftmost element to keep the size at 'k'

            if(right-left+1 > k){
                sum-=nums[left];
             // Decrement its frequency count inside our map

                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
// Condition A: Ensure our window has successfully filled up to size 'k' 
// Condition B: Ensure all 'k' elements are completely DISTINCT (unique keys == 'k')
            if(right-left+1 == k && map.size()==k){
                maxCount=Math.max(maxCount,sum);
            }
            
        }
    return maxCount;
    }
}