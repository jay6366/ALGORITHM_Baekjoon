import java.util.*;
class Point{
    int x, y, distance;
    Point(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = { -1, 0, 1, 0};
        int[] dy = { 0, -1, 0, 1};
        
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(new Point(0,0,1));
        visited[0][0]=true;
        
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            
            if(tmp.x==n-1 && tmp.y==m-1){
                return tmp.distance;
            }
            
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && ny>=0 &&nx<=n-1&&ny<=m-1&&!visited[nx][ny]&&maps[nx][ny]!=0){
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx,ny,tmp.distance+1));
                }
            }

        }
        return -1;
    }
}