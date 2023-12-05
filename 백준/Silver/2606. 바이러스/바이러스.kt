import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val computerCount = br.readLine().toInt()
    val networkCount = br.readLine().toInt()
    
    val networks = Array(computerCount + 1){ mutableListOf<Int>() }
    for (i in 0 until networkCount){
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        networks[a].add(b)
        networks[b].add(a)
    }
    val visited = BooleanArray(computerCount + 1)
    println(dfs(1,networks,visited)-1)
}

fun dfs(start:Int, networks: Array<MutableList<Int>>, visited:BooleanArray): Int{
    if (visited[start]) return 0
    
    visited[start] = true
    var count = 1
    
    for (next in networks[start]){
        count += dfs(next,networks,visited)
    }
    return count
}