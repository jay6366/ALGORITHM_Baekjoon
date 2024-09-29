import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        int index = 0;
        
        for(int i=0; i<bridge_length; i++){
            queue.offer(0);
        }
        //0으로 초기화된 queue 자료구조 
        
        while(!queue.isEmpty()){
            currentWeight = currentWeight - queue.poll();
            time++;
            //queue에서 빠져나갈 때 시간증가처리 눈여겨 보고 생각했어야 할 작은 부분
            if(index < truck_weights.length){
                 if(currentWeight+truck_weights[index] <= weight){
                    queue.offer(truck_weights[index]);
                    currentWeight += truck_weights[index];
                    index++;
                } else {
                    queue.offer(0);
                }               
            }
      
        }
        return time;
    }
}