class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       // Two pointer Approach
       int length = nums.length;
       Set<List<Integer>> list = new HashSet<>();
       Arrays.sort(nums);
       if(length<3 && nums==null){
        return new ArrayList<>();
       }
       for(int i=0;i<length-2;i++){
            int j=i+1;
            int k=length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if(sum>0){
                    k--;
                }
                else{
                       j++;
                }
            }
       }

    return new ArrayList<>(list); 
    }
}