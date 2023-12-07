import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    val k = br.readLine().toLong()

    var low = 1L
    var high = n * n
    var answer = 0L

    while (low <= high) {
        val mid = (low + high) / 2
        var count = 0L

        for (i in 1..n) {
            count += minOf(mid / i, n)
        }

        if (count < k) {
            low = mid + 1
        } else {
            answer = mid
            high = mid - 1
        }
    }

    println(answer)
}
