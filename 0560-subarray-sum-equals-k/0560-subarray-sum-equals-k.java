class Solution {
    public int subarraySum(int[] nums, int k) {
        //Prefix Sum Approach (sum = result(right pointer)-result(left pointer)-1)
        int length=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0,count=0,prefixSum=0;
//  for counting valid subarrays that start exactly at index 0.
        map.put(0,1);
        for(int right=0;right<length;right++){
           sum+=nums[right];
           // If (sum - pastSum == k), then rearranging it gives: pastSum = sum - k.
           prefixSum = sum - k;
           if(map.containsKey(prefixSum)){
                count+=map.get(prefixSum);
           }
           map.put(sum,map.getOrDefault(sum,0)+1);
           
        }
    return count;
    }
}