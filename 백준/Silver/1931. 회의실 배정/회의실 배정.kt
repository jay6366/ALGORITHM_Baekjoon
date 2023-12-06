import java.util.*
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val meetings = Array(N){
        val (start, end) = br.readLine().split(' ').map{ it.toInt() }
        start to end
    }
    
    meetings.sortWith(compareBy({ it.second }, { it.first }))
    var count = 0
    var endTime = 0
    for (meeting in meetings){
        if(meeting.first >= endTime){
            endTime = meeting.second
            count++
        }
    }
    println(count)    
}