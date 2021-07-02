import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val food = Array(n) { BooleanArray(m) { false } } // 세로 n, 가로 m, 오물있으면 true
    val visited = Array(n) { BooleanArray(m) { false } } // 방문했으면 true, 방문 안했으면 false
    val q: Queue<Pair<Int, Int>> = LinkedList()
    repeat(k) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        food[i - 1][j - 1] = true
    }
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    var cnt = -1
    fun bfs(i: Int, j: Int) {
        var curCnt = 1
        q.add(Pair(i, j))
        while (q.isNotEmpty()) {
            val cur = q.poll()
            repeat(4) {
                if (cur.first + dx[it] in 0 until n && cur.second + dy[it] in 0 until m && food[cur.first + dx[it]][cur.second + dy[it]] && !visited[cur.first + dx[it]][cur.second + dy[it]]) { // 만약 오물이 있다면
                    visited[cur.first + dx[it]][cur.second + dy[it]] = true // 방문하고
                    q.add(Pair(cur.first + dx[it], cur.second + dy[it])) // 탐색 위해 추가
                    curCnt++
                }
            }
        }
        cnt = if (curCnt > cnt) curCnt else cnt
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j] && food[i][j]) {
                visited[i][j] = true // 방문 처리
                bfs(i, j)
            }
        }
    }
    println(cnt)
}