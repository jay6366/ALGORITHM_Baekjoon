import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val board = IntArray(N) //각 행에 퀸이 위치하는 열을 저장
    println(nQueen(board,0,N))
}

fun nQueen(board: IntArray, row: Int, N: Int): Int{
    if (row == N){
        return 1
    }
    var count = 0
    for (col in 0 until N){
        if(isSafe(board,row,col,N)){
            board[row] = col
            count += nQueen(board,row+1,N)
        }
    }
    return count
}
fun isSafe(board: IntArray, row:Int, col:Int, N:Int): Boolean {
    for (i in 0 until row){
        if(board[i] == col ||
           Math.abs(board[i] - col) == Math.abs(i - row))
           return false
    }
    return true
}