import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { mutableListOf<Int>() }
    val lenArr = Array(n + 1) { IntArray(n + 1) { -1 } } // 서로 얼만큼 떨어져있는지
    repeat(m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        arr[start].add(end)
        arr[end].add(start)
    }

    val visited = BooleanArray(n + 1) { false }

    data class Node(val num: Int, val depth: Int)

    val q: Queue<Node> = LinkedList()
    fun bfs(user: Int) {
        q.add(Node(user, 1))
        while (q.isNotEmpty()) {
            val nowGuy = q.poll()
            arr[nowGuy.num].forEach {
                if (!visited[it]) {
                    visited[it] = true
                    lenArr[user][it] = nowGuy.depth
                    q.add(Node(it, nowGuy.depth + 1))
                }
            }
        }
    }

    fun reset() {
        for (i in visited.indices) {
            visited[i] = false // 다시 방문 안한것으로 처리
        }
    }

    for (user in 1..n) {
        visited[user] = true
        bfs(user)
        reset()
    }
    val ansSum = IntArray(n + 1) { 0 }
    for (i in 1..n) {
        ansSum[i] = lenArr[i].filter { it >= 1 }.sum()
    }
    var min = 100000
    var answer = -1
    for (i in 1..n) {
        if (lenArr[i].sum() < min) {
            answer = i
            min = lenArr[i].sum()
        }
    }
    println(answer)
}