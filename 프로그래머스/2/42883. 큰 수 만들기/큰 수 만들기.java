import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(char x : number.toCharArray()){
            while(!stack.isEmpty()&& k>0 && x>stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(x);
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.size() > number.length() - k){
            stack.pop();
        }
        
        for(char x : stack){
            sb.append(x);           
        }
        return sb.toString();
    }
}