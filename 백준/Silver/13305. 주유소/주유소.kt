import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val distances = br.readLine().split(' ').map{ it.toLong() }
    val pricePerLiter = br.readLine().split(' ').map{ it.toLong()}
    var totalCost = 0L
    var currentCost = pricePerLiter[0]                        
    
    for (i in 0 until N-1){
        if(currentCost > pricePerLiter[i]){
            currentCost = pricePerLiter[i] 
        }
        totalCost += currentCost * distances[i]
    }
    println(totalCost)                                                   
}