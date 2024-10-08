import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()){
            if(x == '('){
                stack.push(x);
            } else {
                if(stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();                    
                }
            }
        }
        if(stack.isEmpty()){
            return true;            
        }
        return false;        
    }
}