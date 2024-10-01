import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String[] x : clothes){
            if(!map.containsKey(x[1])){
                map.put(x[1],new ArrayList<String>());
            } map.get(x[1]).add(x[0]);
        }
        
        int combination = 1;
        for(ArrayList<String> x : map.values()){
            combination *= (x.size()+1);
        }
        return combination - 1;
    }
}