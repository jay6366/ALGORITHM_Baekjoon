import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val numbers = br.readLine().split(' ').map{ it.toInt() }
    val M = br.readLine().toInt()
    
    val prefixSum = LongArray(N+1){ 0L }
    for(i in 1..N){
        prefixSum[i] = prefixSum[i - 1] + numbers[i - 1]
    }

    val sb = StringBuilder()
    repeat(M){
        val(i,j) = br.readLine().split(' ').map{ it.toInt() }
        sb.append(prefixSum[j] - prefixSum[i-1]).append('\n')
    }   
    println(sb.toString()) 
}