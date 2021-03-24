import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(101) { CharArray(101) } // 101 * 101 보드
    for (i in 0 until n) {
        val list = br.readLine().toCharArray()
        board[i] = list
    }

    val visited = Array(101) { BooleanArray(101) { false } }

    data class Node(val i: Int, val j: Int, val nodeCnt : Int)

    val q: Queue<Node> = LinkedList()
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    var cnt = 0

    fun dfs() {
        q.add(Node(0, 0, 1))
        while (q.isNotEmpty()) {
            val curI = q.peek().i
            val curJ = q.peek().j
            val curCnt = q.peek().nodeCnt
            q.poll()
            if (curI == n - 1 && curJ == m - 1) {
                println(curCnt)
                break
            }
            for (i in 0 until 4) {
                // board 내고, 다음 값이 1이고, 방문하지 않았다면
                if (curI + dx[i] in 0 until n && curJ + dy[i] in 0 until m && board[curI + dx[i]][curJ + dy[i]] == '1' && !visited[curI + dx[i]][curJ + dy[i]]) {
                    visited[curI + dx[i]][curJ + dy[i]] = true // 방문 체크
                    q.add(Node(curI + dx[i], curJ + dy[i], curCnt + 1))
                }
            }
            cnt++
        }
    }

    dfs()
}