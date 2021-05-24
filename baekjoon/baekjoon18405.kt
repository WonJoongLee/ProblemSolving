import java.util.*

// n*n 크기 시험관, k번까지 바이러스 종류
// 바이러스 상하좌우 이동, 크기가 작은 값부터 이동
fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { IntArray(n + 1) }

    data class Virus(val x: Int, val y: Int, val v: Int, val time: Int) : Comparable<Virus> {
        override fun compareTo(other: Virus) = compareValuesBy(this, other, { it.time }, { it.v })
    }

    val q = PriorityQueue<Virus>()
    //val q: Queue<Virus> = LinkedList()
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
            if (row[j] != 0) {
                q.add(Virus(i, j, row[j], 0))
            }
        }
    }

    val (s, x, y) = br.readLine().split(" ").map { it.toInt() }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun bfs() {
        while (q.isNotEmpty()) {
            println(q)
            val cur = q.poll()
            if (cur.time == s) break
            for (i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]
                if (nx in 0 until n && ny in 0 until n) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = cur.v
                        //q.offer(Virus(cur.v, nx, ny, cur.time + 1))
                        q.offer(Virus(nx, ny, cur.v, cur.time + 1))
                    }
                }
            }
        }
    }

    bfs()
    println(arr[x - 1][y - 1])


    // 출력 부분
    println(q)
    for (i in 0 until n) {
        for (j in 0 until n) {
            print("${arr[i][j]} ")
        }
        println()
    }
    print("$s $x $y")
}
