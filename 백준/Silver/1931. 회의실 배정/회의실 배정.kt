import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val meetings = Array(n) {
        val (start, end) = br.readLine().split(' ').map { it.toInt() }
        start to end
    }

    meetings.sortWith(compareBy({ it.second }, { it.first }))

    var count = 0
    var endTime = 0

    for ((start, end) in meetings) {
        if (start >= endTime) {
            endTime = end
            count++
        }
    }
    println(count)
}
