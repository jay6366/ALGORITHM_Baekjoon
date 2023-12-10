import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    while(true){
        val input = br.readLine().split(" ").map{ it.toInt() }
        val k = input[0]
        if(k == 0) break
        
        val selectedList = input.drop(1)
        val pickedList = IntArray(6)
        combinations(selectedList, pickedList,0,0,k)
        println()
    }   
}

fun combinations(selectedList: List<Int>, pickedList: IntArray, toPick: Int, start: Int, k: Int){
    if(toPick == 6){
        println(pickedList.joinToString(" "))
        return
    }
    
    for(i in start until k){
        pickedList[toPick] = selectedList[i]
        combinations(selectedList, pickedList, toPick + 1, i + 1, k)
    }
}