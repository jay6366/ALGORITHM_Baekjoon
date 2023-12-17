import java.io.*

fun main(){
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val numbers = bf.readLine().split(' ').map{ it.toInt() }.sorted()
    
    var sum = 0
    var total = 0
    for ( i in 0 until N){
        sum += numbers[i]
        total += sum
    }
    println(total)   
}