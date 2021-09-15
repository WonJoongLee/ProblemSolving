fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) { 0 } }
    val v = Array(n) { BooleanArray(m) { false } } // false는 미방문
    var ans = -1
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)
    repeat(n) { i ->
        val list = br.readLine().split(" ").map { it.toInt() }
        repeat(m) { j ->
            arr[i][j] = list[j]
        }
    }
    fun bfs(x: Int, y: Int, cnt: Int, sum: Int) {
        if (cnt == 4) {
            if (sum > ans) {
                ans = sum
            }
            return
        }
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (nextX in 0 until n && nextY in 0 until m && !v[nextX][nextY]) {
                v[nextX][nextY] = true
                bfs(nextX, nextY, cnt + 1, sum + arr[nextX][nextY])
                v[nextX][nextY] = false
            }
        }
    }

    // ㅗ 모양 탐색
    fun checkSpecificShape(x: Int, y: Int) {
        repeat(4) { di ->
            var sum = arr[x][y]
            for (i in 0 until 4) {
                if (i == di % 4) {
                    continue
                }
                val nextX = x + dx[i]
                val nextY = y + dy[i]
                if (nextX in 0 until n && nextY in 0 until m) {
                    sum += arr[nextX][nextY]
                } else {
                    break // 한 점이라도 포함되지 않으면 더 이상 볼 필요 없음
                }
            }
            if (sum > ans) {
                ans = sum
            }
        }
    }

    repeat(n) { i ->
        repeat(m) { j ->
            v[i][j] = true
            bfs(i, j, 0, 0)
            v[i][j] = false
            checkSpecificShape(i, j)
        }
    }
    println(ans)
}
