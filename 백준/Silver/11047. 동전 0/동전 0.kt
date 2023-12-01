import java.util.*

fun main(){
    val scanner = Scanner(System.`in`)
    
    val N = scanner.nextInt()
    val K = scanner.nextInt()
    
    val coins = IntArray(N)
    for(i in 0 until N){
        coins[i] = scanner.nextInt()
    }
    
    var count = 0
    var total = K
    for (i in N-1 downTo 0 ){
        if(coins[i] <= total){
            count += total/coins[i]
            total %= coins[i]
        }
    }
    println(count)
}