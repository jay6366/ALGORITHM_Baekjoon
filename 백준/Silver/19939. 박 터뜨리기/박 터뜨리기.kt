import java.util.*

fun main() {
    val reader = Scanner(System.`in`)

    val n = reader.nextInt()
    val k = reader.nextInt()
    var summary = 0
    
    for (i in 1..k) {
        summary += i
    }

    if (summary > n) {
        println(-1)
    } else {
        var remaining = n - summary
        if (remaining % k == 0) println(k - 1)
        else println(k)
    }
}
