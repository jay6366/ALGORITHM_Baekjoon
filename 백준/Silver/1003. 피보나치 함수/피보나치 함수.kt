import java.io.*


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    
    val dp = Array(41){ IntArray(2)}
    dp[0][0] = 1 //피보나치 수 0에 대해 0이 호출되는 횟수
    dp[1][1] = 1 // 피보나치 수 1에 대해 1이 호출되는 횟수
    
    for(i in 2..40){
        dp[i][0] = dp[i-1][0] + dp[i-2][0]
        dp[i][1] = dp[i-1][1] + dp[i-2][1]        
    }
    
    repeat(T) {
    val n = br.readLine().toInt()
    println("${dp[n][0]} ${dp[n][1]}")
    }
 }