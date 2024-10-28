import java.util.*;
class Solution {
    int bfs(int start, List<List<Integer>> graph, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int next : graph.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
    public int solution(int n, int[][] results) {        
        List<List<Integer>> wins = new ArrayList<>();
        List<List<Integer>> losses = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            wins.add(new ArrayList<>());
            losses.add(new ArrayList<>());
        }
        
        int answer = 0;
        
        for(int[] result : results){
            int winner = result[0];
            int loser = result[1];
            wins.get(winner).add(loser);
            losses.get(loser).add(winner);
        }
        
        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            int totalMatches = bfs(i,wins,visited) + bfs(i,losses,visited);
            
            if(totalMatches == n-1){
                answer++;
            }
        }
        return answer;
    }
}