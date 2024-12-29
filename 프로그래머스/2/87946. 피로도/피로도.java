import java.util.*;
class Solution {
    boolean[] visited;
    int count=0;
    int answer=0;
    void DFS(int depth, int remain, int[][] dungeons, int n){
        
        answer = Math.max(answer,count);
        
        for(int i=0; i<n; i++){
            if(!visited[i]&&remain>= dungeons[i][0]){
                visited[i] = true;
                count++;
                DFS(depth+1,remain-dungeons[i][1],dungeons,n);
                count--;
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];
        DFS(0,k,dungeons,n);
        return answer;
    }
}