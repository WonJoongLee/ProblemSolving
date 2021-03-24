import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(1001) { false }
    val stack = Stack<Int>()
    val q: Queue<Int> = LinkedList()
    val arr = Array(10001) { ArrayList<Int>() }

    for (i in 0 until m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        arr[start].add(end)
        arr[end].add(start)
    }

    for (i in 0 until m) {
        arr[i].sort()
        arr[i].reverse()
    }

    fun dfs() {
        stack.add(v)
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            if (visited[cur]) continue
            visited[cur] = true
            for (i in arr[cur]) {
                if (!visited[i]) {
                    stack.push(i)
                }
            }
            print("$cur ")
        }


        for (i in visited.indices) visited[i] = false
        for (i in arr.indices) {
            arr[i].reverse()
        }
    }

    fun bfs() {
        q.add(v)
        visited[v]= true
        while (q.isNotEmpty()) {
            val cur = q.poll()
            for (i in arr[cur]) {
                if (!visited[i]) {
                    q.add(i)
                    visited[i] = true
                }
            }
            print("$cur ")
        }
    }

    dfs()
    println()
    bfs()

}