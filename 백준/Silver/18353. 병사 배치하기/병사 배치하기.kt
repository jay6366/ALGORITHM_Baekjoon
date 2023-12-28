import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val powers = br.readLine().split(" ").map{ it.toInt()}
    val length = Array(N){ 1 }
    
    for (i in 1 until N){
        for(j in 0 until i){
            if(powers[j] > powers[i]){
                length[i] = maxOf(length[i],length[j]+1)               
            }
        }
    }
    
    var maxLength = length.maxOrNull() ?: 0
    println(N - maxLength)   
}

