class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        //  If array is empty or has fewer than 3 elements, a triplet is impossible.
        if (nums==null || nums.length < 3){
            return new ArrayList<>();
        }
        // Use a Set to  reject any duplicate triplets that might be found.
        Set<List<Integer>> resultList = new HashSet<>();
        Arrays.sort(nums);
        //Two pointer approach--------------------------------
        for(int i=0;i<length-2;i++){
                int j=i+1;
                int k=length-1;
                while(j<k){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum==0){
                        resultList.add(Arrays.asList(nums[i],nums[j],nums[k]));
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
       
        return new ArrayList<>(resultList);
    }
}