import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val numbers = IntArray(N){ br.readLine().toInt()}

    numbers.sort()
    
    for(num in numbers){
        println(num)
    }
}