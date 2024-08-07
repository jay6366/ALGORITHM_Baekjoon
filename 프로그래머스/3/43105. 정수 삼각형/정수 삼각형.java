import java.lang.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){
                    triangle[i][j] = triangle[i][j]+triangle[i-1][j];
                } else if (i==j){
                    triangle[i][j] = triangle[i][j]+triangle[i-1][j-1];
                } else {
                    int right = triangle[i][j]+triangle[i-1][j-1];
                    int left = triangle[i][j]+triangle[i-1][j];
                    triangle[i][j] = Math.max(right,left);
                }
                answer = Math.max(answer,triangle[i][j]);
            }
        }
        return answer;
    }
}