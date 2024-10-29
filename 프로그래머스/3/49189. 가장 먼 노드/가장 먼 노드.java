import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프를 인접 리스트로 표현하기 위해 리스트 배열 생성
        List<List<Integer>> graph = new ArrayList<>();
        
        // 1번 노드부터 사용하기 위해 n+1 크기로 초기화
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>()); // 각 노드에 연결된 노드를 저장할 리스트
        }
        
        // 간선 정보를 통해 양방향 그래프 생성
        for(int[] ed : edge){
            int a = ed[0];
            int b = ed[1];
            graph.get(a).add(b); // a->b 간선 추가
            graph.get(b).add(a); // b->a 간선 추가
        }
        
        // 각 노드의 최단 거리를 저장할 배열 (초기값은 -1로 설정해 미방문 상태를 나타냄)
        int[] distance = new int[n+1];
        Arrays.fill(distance,-1);
        distance[1] = 0; // 시작 노드인 1번 노드의 거리를 0으로 설정
        
        // BFS를 위한 Queue 선언 및 초기값으로 1번 노드 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        //BFS 실행
        while(!queue.isEmpty()){
            int node = queue.poll(); // 현재 노드를 큐에서 가져옴
            
            // 현재 노드와 연결된 모든 이웃 노드를 탐색
            for(int neighbor : graph.get(node)){
                
                // 이웃 노드가 아직 방문되지 않은 경우
                if(distance[neighbor] == -1){
                    distance[neighbor] = distance[node] + 1; //최단거리 갱신
                    queue.offer(neighbor); //이웃 노드를 큐에 추가
                }
            }
        }
        
        //최장 거리 찾기
        int maxDistance = 0;
        for(int dist : distance){
            maxDistance = Math.max(maxDistance,dist); //최대거리 갱신
        }
        
        // 최대 거리와 같은 거리를 갖는 노드의 수 계산
        int count = 0;
        for(int dist : distance){
            if(dist == maxDistance){
                count++;
            }
        }
        
        return count;
    }
}