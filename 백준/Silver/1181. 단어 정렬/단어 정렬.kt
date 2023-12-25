import java.io.*

fun main(){
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val N = bf.readLine().toInt()
    val words = mutableSetOf<String>() //중복요소를 허용하지 않는 set
    
    repeat(N){
        words.add(bf.readLine())
    }
    
    val sortedWords = words.sortedWith(compareBy({ it.length }, { it }))
    sortedWords.forEach{ println(it)}  
}