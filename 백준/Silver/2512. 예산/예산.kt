import java.util.*

fun main(){
    val scanner = Scanner(System.`in`)
    
    val N = scanner.nextInt()
    val requests = IntArray(N){ scanner.nextInt() }
    val totalBudget = scanner.nextInt()
    
    var start = 0
    var end = requests.maxOrNull() ?:0
    var result = 0
    
    while(start <= end){
        val mid = (start + end)/2
        val sum = requests.sumOf{ Math.min(it,mid)}
        
        if (sum <= totalBudget){
            result = mid
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    println(result)
    
}