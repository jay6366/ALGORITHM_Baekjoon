import java.util.*;

class Solution {
    class Point{
        int x, y, distance; //distance 파라미터 추가 피드백
        Point(int x, int y, int distance){ //distance 파라미터 추가 피드백
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int level = 0;
        
        int n = maps.length; //배열 행과 열 가져오는 방법 꼭 익히기
        int m = maps[0].length; //배열 행과 열 가져오는 방법 꼭 익히기
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = { 0, 1, 0, -1};
        
        Queue<Point> queue = new LinkedList<>();
        answer++;
        queue.offer(new Point(0,0,1)); //파라미터 추가로 인한 초기화 변경 : 시작점은 (0,0) 위치, 거리는 1
        
        boolean[][] visited = new boolean[n][m]; //boolean visited 배열 초기화 잊지말자
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            //int len = queue.size(); 이 문제에서 len은 필요 없었음
            
            //for(int i=0; i<len; i++){
                
                Point tmp = queue.poll();
                
                if(tmp.x == n-1 && tmp.y == m-1){
                    return tmp.distance;
                } //목적지에 도달한 경우 distance 반환
                
                for(int j=0; j<4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]!=0 && !visited[nx][ny]){
                        //visited배열 조건에 추가 + out of index 조심
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx,ny,tmp.distance+1));
                    }
                }

            //}         
        }
        
        //도달할 수 없는 경우
        return -1;
    }
}