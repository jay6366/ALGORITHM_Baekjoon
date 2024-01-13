import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }

    var result = Int.MAX_VALUE
    var start = 0
    var end = 0
    var summary = arr[0]

    while (true) {
     if (summary >= s) {
         result = minOf(result, end - start + 1)
         summary -= arr[start++]
     } else if (end == n - 1) {
         break
     } else {
         summary += arr[++end]
     }

    }

    if (result == Int.MAX_VALUE) result = 0

    println(result)
}
