import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {       
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String number : phone_book){
            map.put(number,map.getOrDefault(number,0)+1);
        }
        
        for(String number : phone_book){
            for(int i=0; i<number.length();i++){
                String prefix = number.substring(0,i); //생각못한부분
                if(map.containsKey(prefix)){
                    return false;
                }
            }
        }

        return true;
    }
}