import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>(); 
        
        //각 기능 별 완료까지 소요도는 일 수 계산
        for(int i=0; i<progresses.length; i++){
            int days= (100-progresses[i])/speeds[i]
                      +((100-progresses[i])%speeds[i] > 0 ? 1 : 0);
            queue.offer(days);
        }
        
        //배포로직
        while(!queue.isEmpty()){
            int count = 1;
            int day = queue.poll();
            
            while(!queue.isEmpty() && queue.peek()<=day){
                count++;
                queue.poll();
            }
            result.add(count);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}