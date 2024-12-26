import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String member : participant){
            map.put(member,map.getOrDefault(member,0)+1);
        }
        for(String member : completion){
            map.put(member,map.getOrDefault(member,1)-1);           
        }
        
        for(String key : map.keySet()){
            if(map.get(key)!=0){
                return key;
            }
        }
        return null;
    }
}