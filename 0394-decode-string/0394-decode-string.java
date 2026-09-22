class Solution {
    public String decodeString(String s) {
       // Stack Pattern:Expression Evaluation
       Deque<Character> stack = new ArrayDeque<>(); 
       for(char ch:s.toCharArray()){
            // Push digits, '[', and letters into stack
            if(ch!=']'){
                stack.push(ch);
            }
            else{
                // Get the string inside [ ]
                StringBuilder str = new StringBuilder();
                // Pop characters until '[' is found
                while(stack.peek()!='['){
                    // Insert at front to keep original order
                    str.insert(0,stack.pop());
                }
                stack.pop(); // To Remove  '[' from the stack
                StringBuilder repeat = new StringBuilder();// Get the number before '['
                // Get all digits of the number (e.g., "12" in 12[a])
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    repeat.insert(0,stack.pop()); // Insert at front because stack gives reverse order
                }
                int num = Integer.parseInt(repeat.toString());  // Convert number from String to int
                StringBuilder repeatRslt = new StringBuilder();
                //  Repeat the extracted string 'num' times
                for(int i=0;i<num;i++){
                    repeatRslt.append(str);
                }
                // Put expanded string back into stack
                for(char c:repeatRslt.toString().toCharArray()){
                    stack.push(c);
                }
            }
       }
       StringBuilder finalRslt = new StringBuilder();
       // Build final string from stack
       while(!stack.isEmpty()){
        // Insert at front to get correct order
        finalRslt.insert(0,stack.pop());
       }
    return finalRslt.toString();
    }
}

/*
================ STRINGBUILDER NOTES ================

StringBuilder:
- Used to build and modify strings efficiently.
- It is mutable → its contents can be changed.
- append(x) → adds x at the end.
- insert(index, x) → adds x at the given position.
- toString() → converts StringBuilder into String.

In this code:
- str → stores decoded string inside [ ].
- repeat → stores the multiplier number as characters.
- repeatRslt → stores the repeated string.
- finalRslt → stores the final answer.

Example:
StringBuilder sb = new StringBuilder("abc");
sb.append("d");        // abcd
sb.insert(0, "x");     // xabcd
sb.toString();         // "xabcd"


================ toString() NOTES ================

toString():
- Converts an object/StringBuilder into a String.

Example:
StringBuilder sb = new StringBuilder("123");
String s = sb.toString();   // "123"


================ toCharArray() NOTES ================

toCharArray():
- Converts a String into a character array.
- Used when we want to process a String character by character.

Example:
String s = "abc";
char[] arr = s.toCharArray();

arr contains:
'a', 'b', 'c'

In this code:
s.toCharArray() → used to process input one character at a time.
repeatRslt.toString().toCharArray() → converts the expanded StringBuilder
into characters so they can be pushed into the stack.
*/