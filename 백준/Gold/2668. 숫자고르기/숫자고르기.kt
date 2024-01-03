import java.io.*

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

fun main() {
    val input = generateSequence(::readLine).toList()
    val n = input[0].toInt()
    val graph = List(n + 1) { 0 }.toMutableList()
    for (i in 1..n) {
        graph[i] = input[i].toInt()
    }
    val visited = BooleanArray(n + 1) { false }
    val finished = BooleanArray(n + 1) { false }
    val result = mutableListOf<Int>()

    for (x in 1..n) {
        if (!visited[x]) dfs(x, graph, visited, finished, result)
    }

    result.sort()
    println(result.size)
    for (x in result) {
        println(x)
    }
}
