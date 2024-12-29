class Solution {
    static int answer = 0;
    public void DFS(int L, int target, int sum, int[] numbers){
        if(L==numbers.length){
            if(target == sum){
                answer++;
            }
            return;
        }
        DFS(L+1, target, sum+numbers[L], numbers);
        DFS(L+1, target, sum-numbers[L], numbers);        
        
    }
    
    public int solution(int[] numbers, int target) {
        DFS(0,target,0,numbers);
        return answer;
       
    }
}