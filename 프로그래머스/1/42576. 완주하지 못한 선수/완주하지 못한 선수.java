import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for(String person : participant){
            counts.put(person,counts.get(person) == null ? 1 : counts.get(person)+1);
        }
        for(String person : completion){
            counts.put(person, counts.get(person) == null ? 1 : counts.get(person)-1);
        }
        for(String key : counts.keySet()){
            if(counts.get(key)!=0){
                return key;
            }
        }         
        return null;
    }
}