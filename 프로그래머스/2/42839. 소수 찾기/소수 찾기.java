import java.util.*;

class Solution {
    boolean[] visited; //방문여부확인
    Set<Integer> resultSet = new HashSet<>(); //중복 숫자를 방지하기 위한 Set : 놓친부분
    StringBuilder currentString; // DFS에서 현재 조합된 문자열
    
    boolean isPrime(int num){
        if(num<=1) return false;
        for(int i=2; i*i<=num; i++){ 
            //곱을 이루는 두 수 중 적어도 하나는 num제곱근이하라는 사실 활용 => i*i<=num까지만 확인하면된다, 소수가 아닌 케이스 기준으로 생각
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    void DFS(int depth, String numbers, int n){     
        if(depth>0){
            int num = Integer.parseInt(currentString.toString());
            resultSet.add(num);
        }
        //종료조건을 따로 두지 않아도 되는 케이스 for문을 결국 안타게 되므로
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                currentString.append(numbers.charAt(i));
                DFS(depth+1,numbers,n);
                //백트래킹, StringBuilder length() 메소드 있음
                currentString.deleteCharAt(currentString.length()-1);
                visited[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        int n = numbers.length();
        visited = new boolean[n];
        currentString = new StringBuilder();
        
        DFS(0,numbers,n);
        
        int count = 0;
        for(int x : resultSet){
            if(isPrime(x)){
                count++;
            }
        }
        return count;
    }
}