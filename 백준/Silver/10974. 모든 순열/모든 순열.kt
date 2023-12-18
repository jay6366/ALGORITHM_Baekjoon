import java.io.*

fun main(){
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()
    val used = BooleanArray(n+1)
    val permutation = IntArray(n)
  
    fun generatePermutation(depth: Int, n: Int){
        if(depth == n){
            println(permutation.joinToString(" "))
        }
        
        for(i in 1..n){
            if(!used[i]){
                used[i] = true
                permutation[depth] = i
                generatePermutation(depth+1, n)
                used[i] = false
            }
        }
    }
    generatePermutation(0,n)
}