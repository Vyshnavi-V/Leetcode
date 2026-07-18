class Solution {
    public int totalFruit(int[] fruits) {
        //Sliding Window Approach  ---------------HashMap Technique-----------
        int length=fruits.length;
        int left=0;
        int maxCount=0;
        //Key: Fruit type ID, Value: Quantity of this fruit currently in our baskets
        HashMap<Integer,Integer> fruitsMap = new HashMap<>();
        for(int right=0;right<length;right++){
    // Increment the count of the current fruit type. If it's new, start counting from 0 + 1.
           fruitsMap.put(fruits[right],fruitsMap.getOrDefault(fruits[right],0)+1);
// Since we only have 2 baskets, if our map size exceeds 2, we must drop fruits from the left.
//Shrink the Window
           while(fruitsMap.size() > 2){
    // Reduce the count of the leftmost fruit by 1
                fruitsMap.put(fruits[left],fruitsMap.get(fruits[left])-1);
                if(fruitsMap.get(fruits[left])==0){
                    fruitsMap.remove(fruits[left]);
                }
                left++;
           }
        maxCount=Math.max(maxCount,right-left+1);
        }
    return maxCount;
    }
}