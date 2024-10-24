import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        
        int[][]dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            
            //가장 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            //가장 오른쪽
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            
            //가운데
            for(int j=1; j<i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        for(int x : dp[triangle.length-1]){
            answer = Math.max(answer,x);
        }
        
        
//         List<Set<Integer>> dp = new ArrayList<>();
        
//         for(int i=0; i<triangle.length; i++){
//             dp.add(new HashSet<>());           
//         }
//         dp.get(0).add(triangle[0][0]);
        
        
//         for(int i=1; i<triangle.length; i++){
//             for(int j=0; j<triangle[i].length; j++){
//                 dp.get(i) = dp.get(i-1).add()                
//             }

//         }
        
//         for(int y : dp.get(triangle.length-1)){
//             answer = Math.max(y,answer);
//         }
        
        return answer;
              
    }
}