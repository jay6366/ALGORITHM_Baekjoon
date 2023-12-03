import java.util.*

fun main(){
    val N = readLine()!!.toInt();
    val coordinates = readLine()!!.split(' ').map{ it.toInt()}
    val sortedCoordinates = coordinates.distinct().sorted()
    val ranks = sortedCoordinates.withIndex().associate{ (index,value) -> value to index }
    val result = coordinates.map { ranks[it] }
    println(result.joinToString(" "))
}