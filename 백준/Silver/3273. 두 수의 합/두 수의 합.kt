import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = br.readLine().split(' ').map { it.toInt() }.sorted()
    val x = br.readLine().toInt()
    
    var start = 0
    var end = n-1
    var count = 0
    while (start < end){
        val sum = numbers[start]+numbers[end]
        
        if(sum == x){
            count++
            start++
            end--
        } else if (sum < x){
            start++
        } else {
            end--
        }
    }
    println(count)   
}
