class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD =  1000000007; //int 자료형은 -2,147,483,648에서 2,147,483,647까지의 정수를 담을 수 있음
        
        // DP 테이블 초기화 (크기: (m+1) x (n+1)으로 설정하여 인덱스 편의성을 위해 여유 공간 추가)
        int[][] dp = new int [m+1][n+1];
        
        dp[1][1] = 1;
        
        //물에 잠긴 지역 표시 (-1로 설정)
        for(int[] puddle : puddles){
            int x = puddle[0];
            int y = puddle[1];
            dp[x][y] = -1;
        }
        
        //dp 테이블 채우기
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                //물에 잠긴 지역이면 경로 수를 0으로 설정하고 넘어간다.
                if(dp[i][j]==-1){
                    dp[i][j] = 0;
                } else {
                    //위쪽 셀에서 오는 경로 추가
                    if(i>1){
                        dp[i][j] += dp[i-1][j];
                    }
                    
                    //왼쪽 셀에서 오는 경로 추가
                    if(j>1){
                        dp[i][j] += dp[i][j-1];
                    }
                    
                    dp[i][j] = dp[i][j] % MOD;                  
                }
            }
        }
        
        return dp[m][n];
        
    }
}