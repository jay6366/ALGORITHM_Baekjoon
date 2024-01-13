import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val expression = br.readLine()
    
    val tokens = expression.split('-')
    var sum = tokens.first().split('+').sumOf{ it.toInt() }
    
    for(i in 1 until tokens.size){
        sum -= tokens[i].split('+').sumOf{ it.toInt() }
    }
    println(sum)
}