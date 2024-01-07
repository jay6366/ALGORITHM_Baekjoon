import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N,X) = br.readLine().split(' ').map{ it.toInt() }
    val visitors = br.readLine().split(' ').map{ it.toInt() }
    
    var maxSum = 0
    var currentSum = 0
    var maxPeriodCount = 0
    var start = 0
    
    for (end in 0 until N){
        currentSum += visitors[end]
        
        if(end >= X-1){
            if(currentSum > maxSum){
                maxSum = currentSum
                maxPeriodCount = 1
            } else if (currentSum == maxSum){
                maxPeriodCount++
            }
            currentSum -= visitors[start]
            start++
        }
    }
    
    
    if (maxSum == 0){
        println("SAD")
    }
    else {
        println(maxSum)
        println(maxPeriodCount)    
    }
}