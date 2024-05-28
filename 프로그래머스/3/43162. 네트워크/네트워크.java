import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {

          
        boolean[] visited = new boolean[n];
        int networkCount = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(computers,visited,i,n);
                networkCount++; //새로운 네트워크 발견
            }
        }
        
        return networkCount;
    }
    public void bfs(int[][] computers, boolean[] visited, int start, int n){
        Queue<Integer> queue = new LinkedList<Integer>(); //Queue에는 탐색을 시작할 컴퓨터가 들어감.
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int i = 0; i<n; i++){
                if(computers[current][i] == 1 & !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
                        
        }
        
    }
    
}