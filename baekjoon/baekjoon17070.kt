import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    data class Cell(
        val i: Int,
        val j: Int,
        var visited: Boolean, // 또 방문할 일이 없어서 안 쓸듯
        val value: Int,
        var type: Int // 이전에서 현재를 가리킨 타입
        // 0은 가로, 1은 대각선, 2는 세로, 3은 디폴트
    )

    var cnt = 0
    val q: Queue<Cell> = LinkedList()
    val arr = Array(n) { Array(n) { Cell(-1, -1, false, -1, 3) } }
    for (i in 0 until n) {
        val list = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            arr[i][j] = Cell(i, j, false, list[j], 3)
        }
    }
    if (arr[n - 1][n - 1].value == 1) {
        println(0)
        return
    }

    fun isPossible(type: Int, i: Int, j: Int) = when (type) {
        0, 2 -> {
            i in 0 until n && j in 0 until n && arr[i][j].value != 1
        }
        1 -> {
            (i in 0 until n) && (j in 0 until n) && (i - 1 in 0 until n) && (j - 1 in 0 until n) && arr[i][j - 1].value != 1 && arr[i - 1][j].value != 1 && arr[i][j].value != 1
        }
        else -> {
            false
        }
    }

    fun bfs() {
        while (q.isNotEmpty()) {
            val cur = q.poll()
            if (cur.i == n - 1 && cur.j == n - 1) {
                cnt++
                continue
            }
            when (cur.type) {
                0 -> {
                    if (isPossible(0, cur.i, cur.j + 1)) {
                        q.add(Cell(cur.i, cur.j + 1, false, arr[cur.i][cur.j + 1].value, 0))
                    }
                    if (isPossible(1, cur.i + 1, cur.j + 1)) {
                        q.add(Cell(cur.i + 1, cur.j + 1, false, arr[cur.i + 1][cur.j + 1].value, 1))
                    }
                }
                1 -> {
                    if (isPossible(0, cur.i, cur.j + 1)) {
                        q.add(Cell(cur.i, cur.j + 1, false, arr[cur.i][cur.j + 1].value, 0))
                    }
                    if (isPossible(1, cur.i + 1, cur.j + 1)) {
                        q.add(Cell(cur.i + 1, cur.j + 1, false, arr[cur.i + 1][cur.j + 1].value, 1))
                    }
                    if (isPossible(2, cur.i + 1, cur.j)) {
                        q.add(Cell(cur.i + 1, cur.j, false, arr[cur.i + 1][cur.j].value, 2))
                    }
                }
                2 -> {
                    if (isPossible(2, cur.i + 1, cur.j)) {
                        q.add(Cell(cur.i + 1, cur.j, false, arr[cur.i + 1][cur.j].value, 2))
                    }
                    if (isPossible(1, cur.i + 1, cur.j + 1)) {
                        q.add(Cell(cur.i + 1, cur.j + 1, false, arr[cur.i + 1][cur.j + 1].value, 1))
                    }
                }
            }
        }
    }
    arr[0][1].type = 0
    q.add(arr[0][1])
    bfs()
    println(cnt)
}