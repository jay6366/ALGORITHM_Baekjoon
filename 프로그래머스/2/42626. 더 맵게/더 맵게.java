import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            minHeap.add(scoville[i]);
        }
        int count=0;
        while(!minHeap.isEmpty()){
            int num1 = minHeap.poll();
            if(num1 >= K){
                break;
            }
            if(!minHeap.isEmpty()){
                int num2 = minHeap.poll();  
                int num3 = num1 + (num2 * 2);
                minHeap.add(num3); 
                count++;
            } else{
                return -1;
            }
       
        }
        
        return count;
    }
}