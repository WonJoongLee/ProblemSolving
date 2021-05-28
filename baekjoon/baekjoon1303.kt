fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(m) { CharArray(n) }
    val v = Array(m) { BooleanArray(n) { false } }

    for (i in 0 until m) {
        val temp = br.readLine().toString()
        for (j in 0 until n) {
            arr[i][j] = temp[j]
        }
    }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    var sumW = 0
    var sumB = 0
    var curW = 1
    var curB = 1

    fun dfs(i: Int, j: Int, c : Char) {
        v[i][j] = true
        for (k in 0 until 4) {
            // 만약 arr 범위를 벗어난다면 continue
            if (i + dx[k] !in 0 until m || j + dy[k] !in 0 until n) {
                continue
            }
            // c가 있는지 확인하고 탐색 시작
            if (!v[i + dx[k]][j + dy[k]] && arr[i + dx[k]][j + dy[k]] == c) {
                if(c=='W'){
                    curW += 1
                }else{
                    curB += 1
                }
                dfs(i + dx[k], j + dy[k], c)
            }
        }
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!v[i][j] && arr[i][j] == 'W') {
                dfs(i, j, 'W')
                sumW += curW * curW
                curW = 1
            }else if(!v[i][j] && arr[i][j] == 'B') {
                dfs(i, j, 'B')
                sumB += curB * curB
                curB = 1
            }
        }
    }
    println("$sumW $sumB")
}