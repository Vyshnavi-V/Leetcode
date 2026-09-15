class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      //Monotonic Stack Pattern
      int length=asteroids.length;
      Deque<Integer> stack = new ArrayDeque<>();
      for(int i=0;i<asteroids.length;i++){
            int explode=0;
            // Collision only happens when:1.Current asteroid moves LEFT (< 0) 2.Top asteroid in stack moves RIGHT (> 0)
            while(asteroids[i]<0 && !stack.isEmpty() && stack.peek()>0){
                // Case 1: Current asteroid is larger -> stack top explodes
                if(Math.abs(asteroids[i])>stack.peek()){
                    stack.pop();
                }
                // Case 2: Stack top is larger -> current asteroid explodes
                else if(Math.abs(asteroids[i])<stack.peek()){
                    explode=1;
                    break;
                }
                else{   //Case 3: Both are equal size -> both explode
                    stack.pop();
                    explode=1;
                    break;
                }
            }
            if(explode==0){ // If the current asteroid wasn't destroyed, push it to the stack
                stack.push(asteroids[i]); 
            }
      }
      int[] arr = new int[stack.size()];
      for(int i=stack.size()-1;i>=0;i--){  // Convert stack to result array
            arr[i]=stack.pop();
      }
    return arr;
    }
}



/*
Brute Force Approach
int length=asteroids.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<length;i++){
            list.add(asteroids[i]);
        }
        int i=0;
        while(i<list.size()-1){
            int a=list.get(i);
            int b=list.get(i+1);
            if(a>0 && b<0){
                if(a>Math.abs(b)){
                    list.remove(i+1);
                }
                else if(a<Math.abs(b)){
                      list.remove(i);
                       if(i>0){
                          i=i-1;
                      }
                }
                else{
                    list.remove(i+1);
                    list.remove(i);
                    if(i>0){
                          i=i-1;
                      }

                }
            }
            else{
                i++;
            }
            
        }
        
        int[] arr = new int[list.size()];
        for(int j=0;j<list.size();j++){
            arr[j]=list.get(j);
        }
    return arr; */