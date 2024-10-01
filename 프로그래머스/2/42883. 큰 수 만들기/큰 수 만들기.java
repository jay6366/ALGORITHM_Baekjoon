import java.util.*;

class Solution {
    //가장 큰 숫자를 구하는 것이 포인트임, 조합에 초점을 맞췄으면 안됨
    //==>핵심파악이 곧 사용해야할 자료구조에 대한 아이디어로 이어짐 : 스택
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(char x : number.toCharArray()){
            while(!stack.isEmpty() && k>0 && x>stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(x);
        }
        StringBuilder sb = new StringBuilder();
        
        while(stack.size()>number.length()-k){
            stack.pop();
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
            
        return sb.reverse().toString();
    }
}