class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //prefix sum approach----------------
        int length=nums.length;
        int count=0;
        int sum=0;
        //int rem =0;
        HashMap<Integer,Integer> map = new HashMap<>();
    // Base case: A prefix sum of 0 has occurred 1 time before starting the loop.
    // This handles valid subarrays starting directly from index 0.
        map.put(0,1);
        for(int i=0;i<length;i++){
            sum+=nums[i];
            int rem = sum%k; 
    // Handle negative remainders(e.g., -4 % 5 = -4 -> -4 + 5 = 1)
            if(rem<0){
                rem+=k;
            }  
    // If we've seen this remainder before, every past occurrence forms a valid subarray divisible by k ending at index i
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
    //increment the frequency of current remainder
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
    return count;
    }
}