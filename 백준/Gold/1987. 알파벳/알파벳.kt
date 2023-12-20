import java.io.*
import kotlin.math.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (R,C) = br.readLine().split(' ').map{ it.toInt() }
    val board = Array(R){ br.readLine().toCharArray() }
    
    val visited = BooleanArray(26)
    
    var maxCount = 0
    
    fun dfs(x: Int, y: Int, count: Int){
        val charIndex = board[x][y] - 'A'
        if(visited[charIndex]) return
        visited[charIndex] = true
        
        maxCount = max(maxCount, count)
        
        val dx = arrayOf(-1,1,0,0)
        val dy = arrayOf(0,0,-1,1)
        for (i in 0 until 4){
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(nx in 0 until R && ny in 0 until C){
                dfs(nx, ny, count + 1)
            }
        }
        visited[charIndex] = false
    }
    dfs(0,0,1)
    println(maxCount)  
}