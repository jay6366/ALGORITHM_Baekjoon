import java.io.*
import java.util.*

fun main(){
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    var count = N / 5
    var remaining = N % 5
    
    while(count >= 0){
        if (remaining % 3 ==0){
            println(count + remaining / 3)
            return
        }
        count--
        remaining += 5
    }
    println(-1);
}

    
    
    
