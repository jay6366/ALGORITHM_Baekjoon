import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val timeLines = Array(N){ br.readLine().split(' ').map{ it.toInt() }.toIntArray() }
    
    val sortedTimeLines = timeLines.sortedWith(compareBy({ it[1]},{ it[0]}))
    
    var count = 0
    var endTime = 0
    
    for(timeLine in sortedTimeLines){
        if(timeLine[0] >= endTime){
            count += 1
            endTime = timeLine[1]
        }
    }
    println(count)    
}
