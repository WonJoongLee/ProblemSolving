import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    var maxZero = -1
    for (i in 0 until n) {
        val tempList = br.readLine().split(" ").map { it.toInt() }
        for (j in tempList.indices) {
            arr[i][j] = tempList[j]
        }
    }
    val tempArr = Array(n) { IntArray(m) }

    fun bfs(): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        val dx = arrayOf(0, 0, -1, 1)
        val dy = arrayOf(1, -1, 0, 0)
        var cnt = 0
        val visited = Array(n) { BooleanArray(m) { false } }
        val spreadArr = Array(n) { IntArray(m) }

        for (i in 0 until n) {
            for (j in 0 until m) {
                spreadArr[i][j] = tempArr[i][j]
                if (spreadArr[i][j] == 2) {
                    q.add(Pair(i, j))
                }
            }
        }

        while (q.isNotEmpty()) {
            val (i, j) = q.poll()
            for (k in 0 until 4) {
                // arr크기 안에 들어오고, 방문하지 않았고, 바이러스가 퍼질 수 있는 0이라면
                // q에 추가
                if ((i + dx[k] in 0 until n) && (j + dy[k] in 0 until m) && !visited[i + dx[k]][j + dy[k]] && (spreadArr[i + dx[k]][j + dy[k]] == 0)) {
                    q.add(Pair(i + dx[k], j + dy[k]))
                    spreadArr[i + dx[k]][j + dy[k]] = 2
                    visited[i + dx[k]][j + dy[k]] = true // 방문 체크
                }
            }
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (spreadArr[i][j] == 0) { // 확산되지 않은 칸 계산
                    cnt++
                }
            }
        }
        return cnt
    }

    fun makeWall(cnt: Int) {
        if (cnt == 3) {
            val tempMax = bfs()
            if (tempMax > maxZero) {
                maxZero = tempMax
            }
        } else {
            for (i in 0 until n) {
                for (j in 0 until m) {
                    // 0이 있으면 또 보냄
                    if (tempArr[i][j] == 0) {
                        tempArr[i][j] = 1
                        makeWall(cnt + 1)
                        tempArr[i][j] = 0
                    }
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 0) {
                for (k in 0 until n) {
                    for (l in 0 until m) {
                        tempArr[k][l] = arr[k][l]
                    }
                }
                tempArr[i][j] = 1
                makeWall(1)
                tempArr[i][j] = 0
            }
        }
    }
    println(maxZero)
}