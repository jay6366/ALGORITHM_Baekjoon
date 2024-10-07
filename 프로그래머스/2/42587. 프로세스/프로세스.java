import java.util.*;
class Point{
    int index, priority;
    Point(int index, int priority){
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Point> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Point(i,priorities[i]));
        }
        
        
        int count = 0;
        while(!queue.isEmpty()){ //for문이 아닌 queue가 빌 때까지 반복문 실행
            Point tmp = queue.poll();
            boolean isMax = true; //해당 변수 생각못함
            for(Point p : queue){ //queue도 반복문 돌릴 수 있음
                if(tmp.priority<p.priority){
                    isMax = false;
                }               
            }
            if(!isMax){ //이렇게 해야 큐에서 요소를 제거할 때마다 각각의 현재 큐에 맞는 로직 적용 가능
                queue.offer(tmp);
            } else {
                //실행이 될 때 count해야함
                count++;
                if(tmp.index == location){
                    break;
                }
            }
        }          
        return count;
    }
}