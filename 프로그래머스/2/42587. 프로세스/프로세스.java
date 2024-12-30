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
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Point(i,priorities[i]));
        }
        
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            boolean isMax = true;
            for(Point po : queue){
                if(tmp.priority<po.priority){
                    isMax = false;
                     break;
                }
            }
            if(isMax){
                count++;
                if(tmp.index == location){
                    break;
                }
            } else {
                queue.offer(tmp);
            }
        }
        return count;
    }
}