import java.util.*;

class Solution {
    Map<String,PriorityQueue<String>> map = new HashMap<>();
    List<String> route = new ArrayList<>();
    
    public void DFS(String airport){
        while(map.containsKey(airport)&&!map.get(airport).isEmpty()){
            DFS(map.get(airport).poll());
        }
        route.add(0,airport);
    }
    
    public String[] solution(String[][] tickets) {
        for(String[] ticket : tickets){
            map.putIfAbsent(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        DFS("ICN");
        return route.toArray(new String[0]);
    }
}