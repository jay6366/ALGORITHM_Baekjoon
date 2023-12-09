import java.io.*
import java.util.*

fun main(){
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine()
    val numbers = N.map{ it.toString().toInt() }.sortedDescending()
    //문자열에 Map을 취할 경우 각 문자에 대해 람다표현식 적용
    //toString으로 Char타입을 String으로 변환해준다.
    val results = numbers.joinToString("")     
    println(results)     
}

  
