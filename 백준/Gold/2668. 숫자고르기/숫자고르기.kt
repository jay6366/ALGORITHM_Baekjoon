import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val graph = List(n + 1) { 0 }.toMutableList()

    for (i in 1..n) {
        graph[i] = br.readLine().toInt()
    }

    val visited = BooleanArray(n + 1) { false }
    val finished = BooleanArray(n + 1) { false }
    val result = mutableListOf<Int>()

    for (x in 1..n) {
        if (!visited[x]) dfs(x, graph, visited, finished, result)
    }

    br.close()

    result.sort()
    println(result.size)
    result.forEach { println(it) }
}
fun dfs(x: Int, graph: List<Int>, visited: BooleanArray, finished: BooleanArray, result: MutableList<Int>) {
    visited[x] = true
    var y = graph[x]
    if (!visited[y]) {
        dfs(y, graph, visited, finished, result)
    } else if (!finished[y]) {
        while (y != x) {
            result.add(y)
            y = graph[y]
        }
        result.add(x)
    }
    finished[x] = true
}