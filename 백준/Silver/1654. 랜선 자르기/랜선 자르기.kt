import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (K,N) = br.readLine().split(' ').map{ it.toInt() }
    val lengths = LongArray(K){ br.readLine().toLong() }
    
    var min = 1L
    var max = lengths.maxOrNull() ?: 1L
    
    while (min<=max){
        val mid = (min + max)/2
        val count = lengths.sumOf{ it/mid }
        
        if(count < N){
            max = mid -1
        } else {
            min = mid + 1
        }
    }
       
    println(max)
}