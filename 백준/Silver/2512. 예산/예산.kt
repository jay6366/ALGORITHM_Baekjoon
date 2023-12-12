import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val requests = br.readLine().split(" ").map { it.toInt() }
    val totalBudget = br.readLine().toInt()

    var low = 0
    var high = requests.maxOrNull() ?: 0
    var result = 0

    while (low <= high) {
        val mid = (low + high) / 2
        val sum = requests.sumOf { Math.min(it, mid) }

        if (sum > totalBudget) {
            high = mid - 1
        } else {
            low = mid + 1
            result = Math.max(result, mid)
        }
    }

    println(result)
}
