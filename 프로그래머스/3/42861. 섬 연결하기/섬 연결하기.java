import java.util.*;

public class Solution {
    public int solution(int n, int[][] costs) {

    Arrays.sort(costs,(a,b)->a[2]-b[2]);
        
    int[] parents = new int[n];
    for(int i=0; i<n; i++){
        parents[i] = i;
    }
        
    int answer = 0;
    int edge = 0;
    for(int[] cost : costs){
        int x = cost[0];
        int y = cost[1];
        int z = cost[2];
        if(find(parents,x)!=find(parents,y)){
            union(parents,x,y);
            answer += z;
            edge++;
            if(edge == n-1) break;
        }
    }
     return answer;  
    }
    private int find(int[] parent, int x){
        if(parent[x]!=x){
            parent[x] = find(parent,parent[x]);
        }
        return parent[x];
    }
    private void union(int[] parent, int x, int y){
        int rootX = find(parent,x);
        int rootY = find(parent,y);
        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }
}
