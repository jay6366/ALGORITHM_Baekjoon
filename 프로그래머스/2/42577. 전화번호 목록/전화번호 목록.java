import java.util.*;

class Solution {
    public Boolean solution(String[] phone_book) {
        Boolean answer = true;
        
        
        HashMap<String,Boolean> map = new HashMap<String,Boolean>();
        for(String book : phone_book){
            map.put(book,true);
        }
        
        for(String book : phone_book){
            for(int i=0; i<book.length(); i++){
                String prefix = book.substring(0,i);
                if(map.containsKey(prefix)){
                    return false;
                }
            }
        }
                
        return true;
    }
}