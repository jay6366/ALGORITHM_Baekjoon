import java.util.*;
class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    
    int DFS(int node){ //DFS에서 받은 파라미터 node로 놓친부분
        int count = 1;
        visited[node] = true; //놓친부분
        
        for(int neighbor : graph[node]){
            if(!visited[neighbor]){ //방문체크후DFS돌리기
                count += DFS(neighbor);
            }
        }
        return count;
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1]; //ArrayList 이런식으로 정의할 수 있음
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int c1 = wire[0];
            int c2 = wire[1];
            graph[c1].add(Integer.valueOf(c2)); //명시적 Boxing이나 그냥 c2로 처리해도 됨 AutoBoxing
            graph[c2].add(Integer.valueOf(c1));
        }
        
        for(int[] wire : wires){
            int c1 = wire[0];
            int c2 = wire[1];
            graph[c1].remove(Integer.valueOf(c2)); //Integer형태로 바꿔주기 위해 Integer.valueOf가 필요한 것 같다.Boxing
            graph[c2].remove(Integer.valueOf(c1));
            
            visited = new boolean[n+1]; //방문배열초기화 : 놓친부분
            
            int size = DFS(1);
            int diff = Math.abs((n-size)-size); //문제 목적에 맞게
            answer = Math.min(answer,diff);
            
            graph[c1].add(Integer.valueOf(c2));
            graph[c2].add(Integer.valueOf(c1));
            //visited[1] = false;
            //방문처리는 DFS안에서 하기
        }
        
        return answer;
    }
}