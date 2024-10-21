import java.util.*;
class Solution {
    boolean[] visited;
    int answer = 0;
    int count;
    
    void DFS(int depth, int remain, int[][] dungeons, int n){
        //if(depth==n){ 던전을 모두 탐험할 수 있는 없는 경우에도 탐색을 종료할 수 있게 해야함
        answer = Math.max(answer,count);
        //}
        for(int i=0; i<n; i++){
            if(!visited[i] && remain >= dungeons[i][0]){
                visited[i] = true;
                count++;
                DFS(depth+1,remain-dungeons[i][1], dungeons, n);
                count--;
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        count = 0;
        visited = new boolean[n];
        DFS(0, k, dungeons, n);
        return answer;
    }
}