fun main() {
    val br = System.`in`.bufferedReader()
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(501) { IntArray(501) }
    for (i in 0 until m) {
        val list = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            arr[i][j] = list[j]
        }
    }
    val dp = Array(501) { IntArray(501) { -1 } }
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)

    fun tour(curI: Int, curJ: Int): Int {
        if (curI == m - 1 && curJ == n - 1) {
            return 1
        } else if (dp[curI][curJ] == -1) {
            dp[curI][curJ]=0
            for (i in 0 until 4) {
                val nextI = curI + dx[i]
                val nextJ = curJ + dy[i]
                //board밖으로 나가지 않고, next위치 값이 더 작다면, 방문하지 않았다면
                if (nextI in 0 until m && nextJ in 0 until n && arr[curI][curJ] > arr[nextI][nextJ]) {
                    dp[curI][curJ] += tour(nextI, nextJ)
                }
            }
        }
        return dp[curI][curJ]
    }

    print(tour(0, 0))
}
