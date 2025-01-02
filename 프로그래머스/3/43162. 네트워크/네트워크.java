class Solution {
    boolean[] visited;
    
    void DFS(int index, int[][] computers){
        visited[index] = true;
        
        for(int i=0; i<computers.length; i++){
            if(computers[index][i]==1 && !visited[i]){
                DFS(i,computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int networkCount = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(i,computers);
                networkCount++;
            }
        }
        return networkCount;
    }
}