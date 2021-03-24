import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val givenArr = Array(m + 1) { IntArray(n + 1) } // m행 n열 배열 생성
    val costArr = Array(m + 1) { IntArray(n + 1) }
    val visited = Array(m + 1) { BooleanArray(n + 1) { false } }

    data class Node(val i: Int, val j: Int, val cost: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int = cost - other.cost
    }

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)
    val pq = PriorityQueue<Node>()
    for (i in 0 until m) {
        var list = br.readLine().map { it.toInt() }
        for (j in 0 until n) {
            if (list[j] == 48) givenArr[i][j] = 0
            else givenArr[i][j] = 1
            costArr[i][j] = 987654321
            //costArr[i][j] = 0
        }
    }

    pq.add(Node(0, 0, 0))
    costArr[0][0] = 0
    visited[0][0] = true

    fun dij(): Int {
        while (pq.isNotEmpty()) {
            val temp = pq.poll()
            val i = temp.i
            val j = temp.j
            val cost = temp.cost
            if (i == m - 1 && j == n - 1) {
                return cost
            }
            for (a in 0..3) {
                val dxx = i + dx[a]
                val dyy = j + dy[a]
                if (dxx < 0 || dyy < 0 || dxx > m-1 || dyy > n-1) continue
                if (!visited[dxx][dyy] && givenArr[dxx][dyy] == 0 && cost <= costArr[dxx][dyy]) {
                    costArr[dxx][dyy] = cost
                    visited[dxx][dyy] = true
                    pq.add(Node(dxx, dyy, cost))
                } else if (!visited[dxx][dyy] && givenArr[dxx][dyy] == 1 && cost + 1 <= costArr[dxx][dyy]) {
                    costArr[dxx][dyy] = cost + 1
                    visited[dxx][dyy] = true
                    pq.add(Node(dxx, dyy, cost + 1))
                }
            }
        }
        return -1
    }
    println(dij())
}