import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A  = new ArrayList[N+1];
        visited = new boolean[N+1]; //DFS 초기작업 2번 : 방문 배열 초기화
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        } //DFS 초기작업 1번 : 인접리스트로 그래프 표현
        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        } //DFS 초기작업 3번 : 시작노드 스택에 삽입하기. 재귀함수는 스택과 같은 방식으로 처리됨
        System.out.println(count);
    }
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : A[v]){
            if(visited[i] == false){
                DFS(i);
            }
        }
    }
}