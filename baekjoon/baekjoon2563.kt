fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(101) { Array(101) { 0 } }
    var cnt = 0
    repeat(n) {
        val (first, second) = br.readLine().split(" ").map { it.toInt() }
        for (i in first until first + 10) {
            for (j in second until second + 10) {
                if (arr[i][j] != 1) {
                    arr[i][j] = 1
                    cnt++
                }
            }
        }
    }
    println(cnt)
}