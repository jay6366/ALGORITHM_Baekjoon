import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int remainingProgress = 100 - progresses[i];
            int remainingDays = remainingProgress / speeds[i] + 
                (remainingProgress % speeds[i] > 0 ? 1 : 0);
            queue.offer(remainingDays);
        }
        
        while(!queue.isEmpty()){
            int day = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= day){
                count++;
                queue.poll();
            }
            result.add(count);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}