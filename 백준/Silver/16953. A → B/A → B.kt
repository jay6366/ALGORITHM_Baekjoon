import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{ it.toLong() }
    var current = b
    var count = 0
    while(current > a){
        if(current % 2L == 0L){
            current /= 2
        } else if (current % 10L == 1L){
            current /= 10
        } else {
            break
        }
        count++
    }
    
    if (current == a){
        println(count + 1)
    } else {
        println(-1)
    }
}