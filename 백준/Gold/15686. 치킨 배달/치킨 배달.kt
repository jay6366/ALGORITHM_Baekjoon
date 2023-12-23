import java.io.*
import kotlin.math.min

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N,M) = br.readLine().split(" ").map{ it.toInt() }
    val city = Array(N){ br.readLine().split(" ").map{ it.toInt()}}
    val houses = mutableListOf<Pair<Int,Int>>()
    val chickens = mutableListOf<Pair<Int,Int>>()
    
    for (i in 0 until N){
        for(j in 0 until N){
            when(city[i][j]){
                1 -> houses.add(Pair(i,j))
                2 -> chickens.add(Pair(i,j))
            }
        }
    }
    var minDistance = Int.MAX_VALUE
    
    fun calculateChickenDistance(selectedChickens: List<Pair<Int,Int>>): Int {
        var totalDistance = 0
        for (house in houses){
            var distance = Int.MAX_VALUE
            for (chicken in selectedChickens){
                distance = min(distance, Math.abs(house.first-chicken.first)+Math.abs(house.second-chicken.second))
            } 
            totalDistance += distance
        }
        return totalDistance
    }    
    
    fun selectChickens(start:Int, count:Int, selected:List<Pair<Int,Int>>){
        if(count == M){
            minDistance = min(minDistance, calculateChickenDistance(selected))
            return 
        }
        for (i in start until chickens.size){
            selectChickens(i+1, count+1, selected+chickens[i])
        }
    }
    selectChickens(0,0,listOf())
    println(minDistance)
}