import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val m = br.readLine().toInt()
    val query = br.readLine().split(' ').map { it.toInt() }

    arr.sort()

    var answer = StringBuilder()
    for (i in 0 until m) {
        val cnt = countByRange(arr, query[i], query[i])
        answer.append("$cnt ")
    }
    println(answer.toString())
}

fun lowerBound(arr: IntArray, target: Int, start: Int, end: Int): Int {
    var left = start
    var right = end
    while (left < right) {
        val mid = (left + right) / 2
        if (arr[mid] >= target) right = mid
        else left = mid + 1
    }
    return right
}

fun upperBound(arr: IntArray, target: Int, start: Int, end: Int): Int {
    var left = start
    var right = end
    while (left < right) {
        val mid = (left + right) / 2
        if (arr[mid] > target) right = mid
        else left = mid + 1
    }
    return right
}

fun countByRange(arr: IntArray, leftValue: Int, rightValue: Int): Int {
    val rightIndex = upperBound(arr, rightValue, 0, arr.size)
    val leftIndex = lowerBound(arr, leftValue, 0, arr.size)
    return rightIndex - leftIndex
}
