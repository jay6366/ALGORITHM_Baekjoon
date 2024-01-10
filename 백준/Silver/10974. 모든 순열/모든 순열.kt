import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val visited = BooleanArray(N+1){ false }
    val permutation = IntArray(N)
    
    //depth는 현재 순열의 깊이(현재까지 선택된 숫자의 개수)
    fun generatePermutation(depth: Int){
        if(depth == N){
            println(permutation.joinToString(" "))
            return
        }
        for(i in 1..N){
            if(!visited[i]){
                visited[i] = true
                permutation[depth] = i
                generatePermutation(depth+1)
                visited[i] = false
            }
        }
    }
    generatePermutation(0)
}