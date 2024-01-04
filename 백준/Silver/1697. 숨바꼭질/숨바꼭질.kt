import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N,K) = br.readLine().split(' ').map { it.toInt() }
    
    fun bfs() : Int{
        val queue: Queue<Pair<Int,Int>> = LinkedList()
        val visited = BooleanArray(100001){ false }
        queue.add(Pair(N,0))
        
        while (queue.isNotEmpty()){
            val(current, time) = queue.poll()
            
            if(current==K) return time
            if(current !in 0..100000 || visited[current]) continue
            
            visited[current] = true
            queue.add(Pair(current - 1, time + 1))
            queue.add(Pair(current + 1, time + 1))
            queue.add(Pair(current * 2, time + 1))            
        }
        return -1
    }
    println(bfs())
}
