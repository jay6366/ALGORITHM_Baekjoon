import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        //최소힙을 구현하는 기본 클래스 PriortyQueue, 가장 작은 요소가 큐의 맨 앞에 위치함
        //PriorityQueue는 삽입과 삭제 연산이 O(log N) 복잡도를 가짐
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        //모든 음식의 스코필 지수를 힙에 추가
        for(int score : scoville){
            heap.offer(score);
        }
        
        int mixCount = 0;
        
        // 가장 작은 두 지수가 있고,가장 작은 지수가 K이하일 때 계속 반복
        while(heap.size()>1 && heap.peek()<K){
            int leastSpicy = heap.poll();
            int secondLeastSpicy = heap.poll();
            
            int newScoville = leastSpicy + (secondLeastSpicy * 2);
            heap.offer(newScoville);
            mixCount++;
        }
        
        if(heap.peek()<K){
            return -1;
        }
        
        
        return mixCount;
    }
}