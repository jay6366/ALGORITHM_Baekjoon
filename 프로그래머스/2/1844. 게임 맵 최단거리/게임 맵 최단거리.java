import java.util.*;

class Solution {
    
    class Position {
        int x,y;
        
        Position(int x, int y){
            this.x = x;
            this.y= y;
        }
    }
    
    public int solution(int[][] maps) {
        int mapHeight = maps.length;
        int mapWidth = maps[0].length;
        Queue<Position> queue = new LinkedList<>();
        int[][] count = new int [mapHeight][mapWidth];
        boolean[][] visited = new boolean [mapHeight][mapWidth];
        
        count[0][0] = 1;
        visited[0][0] = true;
        
        queue.offer(new Position(0,0));
        
        while(!queue.isEmpty()){
            Position current = queue.poll();
            
            int currentCount = count[current.y][current.x];
                      
            final int[][] moving = {{0,-1}, {0,1},{-1,0},{1,0}};
            for(int i=0; i<moving.length; i++){
                Position moved = new Position(current.x + moving[i][0], current.y + moving[i][1]);
                if(moved.x >= 0 && moved.x <mapWidth && moved.y >= 0 && moved.y < mapHeight 
                                && !visited[moved.y][moved.x] && maps[moved.y][moved.x]==1){
                    count[moved.y][moved.x] = currentCount + 1;
                    visited[moved.y][moved.x] = true;
                    queue.offer(moved);
                }
            }            
        }
        int answer = count[mapHeight-1][mapWidth-1];
        if(answer == 0) return -1;
        
              
        return answer;
    }
}