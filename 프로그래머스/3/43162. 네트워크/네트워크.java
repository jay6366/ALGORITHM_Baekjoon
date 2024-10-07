class Solution {
    boolean[] visited;
    
    public void DFS(int number, int[][] computers){
        visited[number] = true;
        for(int i=0; i<computers.length; i++){
            if(computers[number][i]==1 && !visited[i]){
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