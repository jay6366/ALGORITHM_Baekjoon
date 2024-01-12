import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val budgets = br.readLine().split(' ').map{ it.toInt() }
    val limit = br.readLine().toInt()
    
    var result = 0
    var start = 0
    var end = budgets.maxOrNull() ?: 0
    
    while(start <= end){ 
        var total = 0
        val mid = (start + end)/2
        for(i in 0 until N){
            total += Math.min(budgets[i],mid) 
        }
        if(total > limit){
            end = mid - 1
        } else {
            start = mid + 1
            result = mid
        }
    }
    println(result)
}
